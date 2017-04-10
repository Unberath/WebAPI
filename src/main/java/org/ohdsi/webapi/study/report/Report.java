/**
 * This file was generated by the JPA Modeler
 */ 

package org.ohdsi.webapi.study.report;

import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.ohdsi.webapi.study.Study;

/**
 * @author Chris Knoll <cknoll@ohdsi.org>
 */

@Entity(name="StudyReport")
@Table(name="REPORT")
public class Report { 

    @Id
    @GeneratedValue(generator="REPORT_SEQ",strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name="REPORT_SEQ",sequenceName="REPORT_SEQ",allocationSize=1)
    private Integer id;

    @Column(name="NAME",columnDefinition="VARCHAR(256)")
    @Basic
    private String name;

    @Column(name="DESCRIPTION",columnDefinition="VARCHAR(2000)")
    @Basic
    private String description;

    @Column(name="CREATED_BY",columnDefinition="VARCHAR(100)")
    @Basic
    private String createdBy;

    @Column(name="CREATED_DATE",columnDefinition="DATETIME")
    @Basic
    @Temporal(TemporalType.DATE)
    private Date createdDate;

    @Column(name="MODIFIED_BY",columnDefinition="VARCHAR(100)")
    @Basic
    private String modifiedBy;

    @Column(name="MODIFIED_DATE",columnDefinition="DATETIME",updatable=false)
    @Basic
    @Temporal(TemporalType.DATE)
    private Date modifiedDate;

    @Column(name="STATUS",columnDefinition="VARCHAR(20)",updatable=false)
    @Basic
    private ReportStatus status;

    @ElementCollection(fetch=FetchType.LAZY)
    @CollectionTable(name="REPORT_CONTENT",joinColumns={@JoinColumn(name="REPORT_ID",referencedColumnName="ID")})
    private List<ReportContent> content = new java.util.ArrayList<ReportContent>();

    @ElementCollection(fetch=FetchType.LAZY)
    @CollectionTable(name="REPORT_COVARIATE_XREF",joinColumns={@JoinColumn(name="REPORT_ID",referencedColumnName="ID")})
    private Set<ReportCovariate> covariates = new java.util.HashSet<ReportCovariate>();

    @ElementCollection(fetch=FetchType.LAZY)
    @OrderColumn(name="ORDINAL")
    @CollectionTable(name="REPORT_SOURCE_XREF",joinColumns={@JoinColumn(name="REPORT_ID",referencedColumnName="ID")})
    private List<ReportSource> sources = new java.util.ArrayList<ReportSource>();

    @ElementCollection(fetch=FetchType.LAZY)
    @OrderColumn(name="ORDINAL")
    @CollectionTable(name="REPORT_COHORTPAIR_XREF",joinColumns={@JoinColumn(name="REPORT_ID",referencedColumnName="ID")})
    private List<ReportCohortPair> cohortPairs = new java.util.ArrayList<ReportCohortPair>();

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = Study.class)
    @JoinTable(name="REPORT_STUDY_XREF",joinColumns={@JoinColumn(name="REPORT_ID",referencedColumnName="ID")},inverseJoinColumns={@JoinColumn(name="STUDY_ID",referencedColumnName="ID")})
    private Study study;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return this.createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public ReportStatus getStatus() {
        return this.status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public List<ReportContent> getContent() {
        return this.content;
    }

    public void setContent(List<ReportContent> content) {
        this.content = content;
    }

    public Set<ReportCovariate> getCovariates() {
        return this.covariates;
    }

    public void setCovariates(Set<ReportCovariate> covariates) {
        this.covariates = covariates;
    }

    public List<ReportSource> getSources() {
        return this.sources;
    }

    public void setSources(List<ReportSource> sources) {
        this.sources = sources;
    }

    public List<ReportCohortPair> getCohortPairs() {
        return this.cohortPairs;
    }

    public void setCohortPairs(List<ReportCohortPair> cohortPairs) {
        this.cohortPairs = cohortPairs;
    }

    public Study getStudy() {
        return this.study;
    }

    public void setStudy(Study study) {
        this.study = study;
    }


}
