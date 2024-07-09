package com.forohub.Foro.Hub.domain.respuesta;


import com.forohub.Foro.Hub.domain.topico.Topico;
import com.forohub.Foro.Hub.domain.topico.TopicoRepository;
import com.forohub.Foro.Hub.domain.usuario.Usuario;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
@Table(name="respuestas")
@Entity(name="Respuesta")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Respuesta {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String mensaje;
        private LocalDateTime fechaCreacion;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "usuario_id")
        private Usuario Usuario;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "topico_id")
        private Topico topico;

        public Respuesta(DatosRegistroRespuestas datos, Usuario usuario, Topico id) {
                this.mensaje= datos.mensaje();
                this.fechaCreacion=datos.fecha();
                this.Usuario=usuario;
                this.topico=id;
        }

        public void actualizarRespuesta(DatosActualizarRespuesta datos) {
                if(datos.mensaje()!=null) {
                        this.mensaje = datos.mensaje();
                }
                if(datos.fecha()!=null){
                        this.fechaCreacion=datos.fecha();
                }
        }
}
