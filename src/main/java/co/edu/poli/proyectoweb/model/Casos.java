package co.edu.poli.proyectoweb.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;


@Entity
@Table(name = "Casos")
public class Casos {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer idCaso;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        private String NombreCaso;

        private String Caso;

        public Casos() {
        }

        public Casos(Integer idCaso, User user, String nombreCaso, String caso) {
                this.idCaso = idCaso;
                this.user = user;
                NombreCaso = nombreCaso;
                Caso = caso;
        }

        public String getCaso() {
                return Caso;
        }

        public void setCaso(String caso) {
                Caso = caso;
        }

        public Integer getIdCaso() {
                return idCaso;
        }

        public void setIdCaso(Integer idCaso) {
                this.idCaso = idCaso;
        }

        public User getUser() {
                return user;
        }

        public void setUser(User idUsuario) {
                this.user = idUsuario;
        }

        public String getNombreCaso() {
                return NombreCaso;
        }

        public void setNombreCaso(String nombreCaso) {
                NombreCaso = nombreCaso;
        }
}
