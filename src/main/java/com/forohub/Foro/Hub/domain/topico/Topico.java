package com.forohub.Foro.Hub.domain.topico;

import com.forohub.Foro.Hub.domain.curso.Curso;
import com.forohub.Foro.Hub.domain.respuesta.Respuesta;
import com.forohub.Foro.Hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter
@Table(name="topicos")
@Entity(name="Topico")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String mensaje;
    private LocalDateTime fechaCreacion;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @OneToMany(mappedBy = "topico", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Respuesta> respuestas;

    public Topico(DatosRegistroTopico datos, Optional<Usuario> usuario, Curso curso) {
        this.titulo= datos.titulo();
        this.mensaje= datos.mensaje();
        this.fechaCreacion=datos.fecha();
        this.status= datos.status();
        this.usuario=usuario.get();
        this.curso=curso;
    }

    public Long getId() {return id;}
    public String getTitulo() {return titulo;}
    public String getMensaje() {return mensaje;}
    public LocalDateTime getFechaCreacion() {return fechaCreacion;}
    public String getStatus() {return status;}
    public Usuario getUsuario() {return usuario;}
    public Curso getCurso() {return curso;}
    public List<Respuesta> getRespuestas() {return respuestas;}

    public void actualizarTopico(DatosActualizacionTopico datos, Curso curso) {
        if (datos.titulo() != null) {
            this.titulo = datos.titulo();
        }
        if (datos.mensaje() != null) {
            this.mensaje = datos.mensaje();
        }
        if (datos.status() != null) {
            this.status = datos.status();
        }
        this.curso = curso;
    }

    public void agregarRespuesta(Respuesta respuesta){
        this.respuestas.add(respuesta);
    }

    @Override
    public String toString() {
        return "Topico{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", mensaje='" + mensaje + '\'' +
                ", fechaCreacion=" + fechaCreacion +
                ", status='" + status + '\'' +
                ", usuario=" + usuario +
                ", curso=" + curso +
                ", respuestas=" + respuestas +
                '}';
    }
}
