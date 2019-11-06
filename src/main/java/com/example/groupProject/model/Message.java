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
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author antonis
 */
@Entity
@Table(name = "message")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Message.findAll", query = "SELECT m FROM Message m")
    , @NamedQuery(name = "Message.findByMessageid", query = "SELECT m FROM Message m WHERE m.messageid = :messageid")
    , @NamedQuery(name = "Message.findByMessagetimestamp", query = "SELECT m FROM Message m WHERE m.messagetimestamp = :messagetimestamp")})
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "messageid")
    private Integer messageid;
    @Lob
    @Size(max = 16777215)
    @Column(name = "messagesize")
    private String messagesize;
    @Column(name = "messagetimestamp")
    @Temporal(TemporalType.TIMESTAMP)
    private Date messagetimestamp;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "messageid")
    private Collection<Directconversation> directconversationCollection;

    public Message() {
    }

    public Message(Integer messageid) {
        this.messageid = messageid;
    }

    public Integer getMessageid() {
        return messageid;
    }

    public void setMessageid(Integer messageid) {
        this.messageid = messageid;
    }

    public String getMessagesize() {
        return messagesize;
    }

    public void setMessagesize(String messagesize) {
        this.messagesize = messagesize;
    }

    public Date getMessagetimestamp() {
        return messagetimestamp;
    }

    public void setMessagetimestamp(Date messagetimestamp) {
        this.messagetimestamp = messagetimestamp;
    }

    @XmlTransient
    public Collection<Directconversation> getDirectconversationCollection() {
        return directconversationCollection;
    }

    public void setDirectconversationCollection(Collection<Directconversation> directconversationCollection) {
        this.directconversationCollection = directconversationCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (messageid != null ? messageid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Message)) {
            return false;
        }
        Message other = (Message) object;
        if ((this.messageid == null && other.messageid != null) || (this.messageid != null && !this.messageid.equals(other.messageid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.groupProject.model.Message[ messageid=" + messageid + " ]";
    }
    
}
