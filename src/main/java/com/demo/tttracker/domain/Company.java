package com.demo.tttracker.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "ttt_company")
@NamedQueries({
        @NamedQuery(name = "Company.findAll", query = "select c from Company c"),
        @NamedQuery(name = "Company.findByIdCompany", query = "select c from Company c where c.idCompany = :idCompany"),
        @NamedQuery(name = "Company.findByCompanyName", query = "select c from Company c where c.companyName = :companyName")
})
public class Company implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_company")
    private Integer idCompany;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "company_name")
    private String companyName;

    @Column(name = "who_created")
    private String whoCreated;

    @Column(name = "who_updated")
    private String whoUpdated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "when_created")
    private Calendar whenCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "when_created")
    private Calendar whenUpdated;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "company")
    private List<Project> projects;

    public Company() {
    }

    public Integer getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Integer idCompany) {
        this.idCompany = idCompany;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getWhoCreated() {
        return whoCreated;
    }

    public void setWhoCreated(String whoCreated) {
        this.whoCreated = whoCreated;
    }

    public String getWhoUpdated() {
        return whoUpdated;
    }

    public void setWhoUpdated(String whoUpdated) {
        this.whoUpdated = whoUpdated;
    }

    public void setWhenCreated(Calendar whenCreated) {
        this.whenCreated = whenCreated;
    }

    public void setWhenUpdated(Calendar whenUpdated) {
        this.whenUpdated = whenUpdated;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        return idCompany != null ? idCompany.equals(company.idCompany) : company.idCompany == null;
    }

    @Override
    public int hashCode() {
        return idCompany != null ? idCompany.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Company{" +
                "idCompany=" + idCompany +
                ", companyName='" + companyName + '\'' +
                ", whoCreated='" + whoCreated + '\'' +
                ", whoUpdated='" + whoUpdated + '\'' +
                ", whenCreated=" + whenCreated +
                ", whenUpdated=" + whenUpdated +
                ", projects=" + projects +
                '}';
    }
}
