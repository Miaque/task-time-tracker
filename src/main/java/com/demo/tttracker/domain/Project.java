package com.demo.tttracker.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "ttt_project")
@NamedQueries({
        @NamedQuery(name = "Project.findAll", query = "select p from Project p"),
        @NamedQuery(name = "Project.findByIdProject", query = "select p from Project p where p.idProject = :idProject"),
        @NamedQuery(name = "Project.findByProjectName", query = "select p from Project p where p.projectName = :projectName")
})
public class Project implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_project")
    private Integer idProject;

    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "project_name")
    private String projectName;

    @JoinColumn(name = "id_company", referencedColumnName = "id_company")
    @ManyToOne
    private Company company;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "project")
    private List<Task> tasks;

    public Project() {
    }

    public Integer getIdProject() {
        return idProject;
    }

    public void setIdProject(Integer idProject) {
        this.idProject = idProject;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Project project = (Project) o;

        return idProject.equals(project.idProject);
    }

    @Override
    public int hashCode() {
        return idProject.hashCode();
    }

    @Override
    public String toString() {
        return "Project{" +
                "idProject=" + idProject +
                ", projectName='" + projectName + '\'' +
                ", company=" + company +
                ", tasks=" + tasks +
                '}';
    }
}
