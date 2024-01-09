package com.mkpits.railway.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity
@Table(name = "Station_Master")
public class StationMaster {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Station_id")
        private int station_id;
        @Column(name = "Station_name")
        private String Station_name;
        @Column(name = "Station_type")
        private String station_type;
        @Column(name = "Station_code")
        private String station_code;
        @Column(name = "Station_update")
        private LocalDateTime station_update;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "Contact_id",referencedColumnName = "Contact_id")
        private Station_Contact stationContact;

        public StationMaster() {
        }

        public StationMaster(String station_name, String station_type, String station_code, LocalDateTime station_update,Station_Contact stationContact ) {
                Station_name = station_name;
                this.station_type = station_type;
                this.station_code = station_code;
                this.station_update = station_update;
                this.stationContact=stationContact;

        }

        public int getStation_id() {
                return station_id;
        }

        public void setStation_id(int station_id) {
                this.station_id = station_id;
        }

        public String getStation_name() {
                return Station_name;
        }

        public void setStation_name(String station_name) {
                Station_name = station_name;
        }

        public String getStation_type() {
                return station_type;
        }

        public void setStation_type(String station_type) {
                this.station_type = station_type;
        }

        public String getStation_code() {
                return station_code;
        }

        public void setStation_code(String station_code) {
                this.station_code = station_code;
        }

        public LocalDateTime getStation_update() {
                return station_update;
        }

        public void setStation_update(LocalDateTime station_update) {
                this.station_update = station_update;
        }

        public Station_Contact getStationContact() {
                return stationContact;
        }

        public void setStationContact(Station_Contact stationContact) {
                this.stationContact = stationContact;
        }
}
