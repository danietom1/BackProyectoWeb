package co.edu.poli.proyectoweb.model;

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

        private String Caso;

        public Casos() {
        }

        public Casos(Integer idCaso, User user, String caso) {
                this.idCaso = idCaso;
                this.user = user;
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
}
