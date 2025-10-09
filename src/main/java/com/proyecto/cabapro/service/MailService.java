package com.proyecto.cabapro.service;

import com.proyecto.cabapro.model.Asignacion;
import com.proyecto.cabapro.model.Partido;
import com.proyecto.cabapro.model.Arbitro;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;              // <- NUEVO
import org.springframework.context.i18n.LocaleContextHolder; // <- NUEVO
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Locale; // <- NUEVO

@Service
public class MailService {

    private final JavaMailSender mailSender;
    private final MessageSource messages;   // <- NUEVO

    @Value("${spring.mail.from:Cabapro <no-reply@cabapro.local>}")
    private String from;

    // inyecta MessageSource (Spring ya lo provee con tus messages*.properties)
    public MailService(JavaMailSender mailSender, MessageSource messages) {
        this.mailSender = mailSender;
        this.messages = messages;
    }

    /** Aviso cuando se crea una asignación (estado PENDIENTE). */
    public void notificarNuevaAsignacion(Asignacion asg) {
        Arbitro a = asg.getArbitro();
        Partido p = asg.getPartido();
        if (a == null || p == null || a.getCorreo() == null || a.getCorreo().isBlank()) return;

        // usa el locale actual (o pásalo por parámetro si prefieres)
        Locale locale = LocaleContextHolder.getLocale();

        String subject = messages.getMessage("mail.asignacion.subject", null, locale);

        // {0}=nombre árbitro, {1}=local, {2}=visitante, {3}=fecha, {4}=torneo, {5}=monto
        String body = messages.getMessage("mail.asignacion.body",
                new Object[]{
                        safe(a.getNombre()),
                        safe(p.getEquipoLocal()),
                        safe(p.getEquipoVisitante()),
                        String.valueOf(p.getFecha()), // puedes mejorar formateo luego
                        p.getTorneo() != null ? safe(p.getTorneo().getNombre()) : "-",
                        asg.getMonto() != null ? "$" + asg.getMonto().setScale(2) : "$0.00"
                },
                locale
        );

        enviar(a.getCorreo(), subject, body);
    }

    private String safe(String s) { return s == null ? "-" : s; }

    private void enviar(String to, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo(to);
        msg.setSubject(subject);
        msg.setText(body);
        mailSender.send(msg);
    }
}
