/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author antonis
 */
@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
    , @NamedQuery(name = "User.findByUserid", query = "SELECT u FROM User u WHERE u.userid = :userid")
    , @NamedQuery(name = "User.findByUserfirstname", query = "SELECT u FROM User u WHERE u.userfirstname = :userfirstname")
    , @NamedQuery(name = "User.findByUserlastname", query = "SELECT u FROM User u WHERE u.userlastname = :userlastname")
    , @NamedQuery(name = "User.findByUseremail", query = "SELECT u FROM User u WHERE u.useremail = :useremail")
    , @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username")
    , @NamedQuery(name = "User.findByUserpassword", query = "SELECT u FROM User u WHERE u.userpassword = :userpassword")
    , @NamedQuery(name = "User.findByIsactive", query = "SELECT u FROM User u WHERE u.isactive = :isactive")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userid")
    private Integer userid;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "userfirstname")
    private String userfirstname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "userlastname")
    private String userlastname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "useremail")
    private String useremail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "userpassword")
    private String userpassword;
    @Column(name = "isactive")
    private Boolean isactive;
    @JoinTable(name = "member", joinColumns = {
        @JoinColumn(name = "memberid", referencedColumnName = "userid")}, inverseJoinColumns = {
        @JoinColumn(name = "channelid", referencedColumnName = "roomid")})
    @ManyToMany
    @JsonIgnore
    private Collection<Room> roomCollection;
    @JoinTable(name = "userrole", joinColumns = {
        @JoinColumn(name = "userid", referencedColumnName = "userid")}, inverseJoinColumns = {
        @JoinColumn(name = "roleid", referencedColumnName = "roleid")})
    @ManyToMany(fetch = FetchType.EAGER)
    @JsonIgnore
    private Collection<Role> roleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "senderid")
    @JsonIgnore
    private Collection<Directconversation> directconversationCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "receiverid")
    @JsonIgnore
    private Collection<Directconversation> directconversationCollection1;

    public User() {
    }

    public User(Integer userid) {
        this.userid = userid;
    }

    public User(Integer userid, String userfirstname, String userlastname, String useremail, String username, String userpassword) {
        this.userid = userid;
        this.userfirstname = userfirstname;
        this.userlastname = userlastname;
        this.useremail = useremail;
        this.username = username;
        this.userpassword = userpassword;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUserfirstname() {
        return userfirstname;
    }

    public void setUserfirstname(String userfirstname) {
        this.userfirstname = userfirstname;
    }

    public String getUserlastname() {
        return userlastname;
    }

    public void setUserlastname(String userlastname) {
        this.userlastname = userlastname;
    }

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword;
    }

    public Boolean getIsactive() {
        return isactive;
    }

    public void setIsactive(Boolean isactive) {
        this.isactive = isactive;
    }

    @XmlTransient
    public Collection<Room> getRoomCollection() {
        return roomCollection;
    }

    public void setRoomCollection(Collection<Room> roomCollection) {
        this.roomCollection = roomCollection;
    }

    @XmlTransient
    public Collection<Role> getRoleCollection() {
        return roleCollection;
    }

    public void setRoleCollection(Collection<Role> roleCollection) {
        this.roleCollection = roleCollection;
    }

    @XmlTransient
    public Collection<Directconversation> getDirectconversationCollection() {
        return directconversationCollection;
    }

    public void setDirectconversationCollection(Collection<Directconversation> directconversationCollection) {
        this.directconversationCollection = directconversationCollection;
    }

    @XmlTransient
    public Collection<Directconversation> getDirectconversationCollection1() {
        return directconversationCollection1;
    }

    public void setDirectconversationCollection1(Collection<Directconversation> directconversationCollection1) {
        this.directconversationCollection1 = directconversationCollection1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userid != null ? userid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.userid == null && other.userid != null) || (this.userid != null && !this.userid.equals(other.userid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.groupProject.model.User[ userid=" + userid + " ]";
    }

    public String getUserPass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
