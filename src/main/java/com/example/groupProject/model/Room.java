/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author antonis
 */
@Entity
@Table(name = "room")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Room.findAll", query = "SELECT r FROM Room r")
    , @NamedQuery(name = "Room.findByRoomid", query = "SELECT r FROM Room r WHERE r.roomid = :roomid")
    , @NamedQuery(name = "Room.findByRoomname", query = "SELECT r FROM Room r WHERE r.roomname = :roomname")
    , @NamedQuery(name = "Room.findByRoomadmin", query = "SELECT r FROM Room r WHERE r.roomadmin = :roomadmin")
    , @NamedQuery(name = "Room.findByPublic1", query = "SELECT r FROM Room r WHERE r.public1 = :public1")
    , @NamedQuery(name = "Room.findByRoombirth", query = "SELECT r FROM Room r WHERE r.roombirth = :roombirth")})
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "roomid")
    private Integer roomid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "roomname")
    private String roomname;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roomadmin")
    private int roomadmin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "public")
    private boolean public1;
    @Basic(optional = false)
    @NotNull
    @Column(name = "roombirth")
    @Temporal(TemporalType.TIMESTAMP)
    private Date roombirth;
    @ManyToMany(mappedBy = "roomCollection")
    private Collection<User> userCollection;

    public Room() {
    }

    public Room(Integer roomid) {
        this.roomid = roomid;
    }

    public Room(Integer roomid, String roomname, int roomadmin, boolean public1, Date roombirth) {
        this.roomid = roomid;
        this.roomname = roomname;
        this.roomadmin = roomadmin;
        this.public1 = public1;
        this.roombirth = roombirth;
    }

    public Integer getRoomid() {
        return roomid;
    }

    public void setRoomid(Integer roomid) {
        this.roomid = roomid;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public int getRoomadmin() {
        return roomadmin;
    }

    public void setRoomadmin(int roomadmin) {
        this.roomadmin = roomadmin;
    }

    public boolean getPublic1() {
        return public1;
    }

    public void setPublic1(boolean public1) {
        this.public1 = public1;
    }

    public Date getRoombirth() {
        return roombirth;
    }

    public void setRoombirth(Date roombirth) {
        this.roombirth = roombirth;
    }

    @XmlTransient
    public Collection<User> getUserCollection() {
        return userCollection;
    }

    public void setUserCollection(Collection<User> userCollection) {
        this.userCollection = userCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roomid != null ? roomid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Room)) {
            return false;
        }
        Room other = (Room) object;
        if ((this.roomid == null && other.roomid != null) || (this.roomid != null && !this.roomid.equals(other.roomid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.groupProject.model.Room[ roomid=" + roomid + " ]";
    }
    
}
