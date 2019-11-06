/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.groupProject.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author antonis
 */
@Entity
@Table(name = "directconversation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Directconversation.findAll", query = "SELECT d FROM Directconversation d")
    , @NamedQuery(name = "Directconversation.findByConversationid", query = "SELECT d FROM Directconversation d WHERE d.conversationid = :conversationid")})
public class Directconversation implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "conversationid")
    private Integer conversationid;
    @JoinColumn(name = "messageid", referencedColumnName = "messageid")
    @ManyToOne(optional = false)
    private Message messageid;
    @JoinColumn(name = "senderid", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User senderid;
    @JoinColumn(name = "receiverid", referencedColumnName = "userid")
    @ManyToOne(optional = false)
    private User receiverid;

    public Directconversation() {
    }

    public Directconversation(Integer conversationid) {
        this.conversationid = conversationid;
    }

    public Integer getConversationid() {
        return conversationid;
    }

    public void setConversationid(Integer conversationid) {
        this.conversationid = conversationid;
    }

    public Message getMessageid() {
        return messageid;
    }

    public void setMessageid(Message messageid) {
        this.messageid = messageid;
    }

    public User getSenderid() {
        return senderid;
    }

    public void setSenderid(User senderid) {
        this.senderid = senderid;
    }

    public User getReceiverid() {
        return receiverid;
    }

    public void setReceiverid(User receiverid) {
        this.receiverid = receiverid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (conversationid != null ? conversationid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Directconversation)) {
            return false;
        }
        Directconversation other = (Directconversation) object;
        if ((this.conversationid == null && other.conversationid != null) || (this.conversationid != null && !this.conversationid.equals(other.conversationid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.groupProject.model.Directconversation[ conversationid=" + conversationid + " ]";
    }
    
}
