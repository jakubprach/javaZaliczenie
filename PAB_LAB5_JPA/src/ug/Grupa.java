/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ug;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author domin
 */
@Entity
@Table(name = "Grupa")
@NamedQueries({
    @NamedQuery(name = "Grupa.findAll", query = "SELECT g FROM Grupa g"),
    @NamedQuery(name = "Grupa.findByGroupNumber", query = "SELECT g FROM Grupa g WHERE g.groupNumber = :groupNumber"),
    @NamedQuery(name = "Grupa.findByFieldOfStudy", query = "SELECT g FROM Grupa g WHERE g.fieldOfStudy = :fieldOfStudy")})
public class Grupa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "group_number")
    private String groupNumber;
    @Column(name = "field_of_study")
    private String fieldOfStudy;

    public Grupa() {
    }

    public Grupa(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getFieldOfStudy() {
        return fieldOfStudy;
    }

    public void setFieldOfStudy(String fieldOfStudy) {
        this.fieldOfStudy = fieldOfStudy;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupNumber != null ? groupNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Grupa)) {
            return false;
        }
        Grupa other = (Grupa) object;
        if ((this.groupNumber == null && other.groupNumber != null) || (this.groupNumber != null && !this.groupNumber.equals(other.groupNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ug.Grupa[ groupNumber=" + groupNumber + " ]";
    }
    
}
