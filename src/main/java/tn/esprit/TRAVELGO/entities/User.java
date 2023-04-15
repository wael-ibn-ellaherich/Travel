package tn.esprit.TRAVELGO.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id ;
    private String username;
    private String password;
    private String companyName;
    private String email;
    private String localisationCompany;
    private String adressUser;
    public Long getId() {
		return id;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getCompanyName() {
		return companyName;
	}
	public String getEmail() {
		return email;
	}
	public String getLocalisationCompany() {
		return localisationCompany;
	}
	public String getAdressUser() {
		return adressUser;
	}
	public int getPhoneNumberUser() {
		return phoneNumberUser;
	}
	public boolean isEnable() {
		return isEnable;
	}
	public Long getIdCompany() {
		return idCompany;
	}
	public SexeType getSexeUser() {
		return sexeUser;
	}
	public Collection<Role> getRoles() {
		return roles;
	}
	public Set<ImageUser> getImageUser1() {
		return ImageUser1;
	}
	public List<Business> getBusinesses() {
		return businesses;
	}
	public Salary getSalary() {
		return salary;
	}
	public Warn getWarn() {
		return warn;
	}
	public List<Reunion> getReunions() {
		return reunions;
	}
	public List<Reunion> getReunionsCompany() {
		return ReunionsCompany;
	}
	public Domain getDomain() {
		return domain;
	}
	public Profession getProfession() {
		return profession;
	}
	public List<Formation> getFormations() {
		return formations;
	}
	public List<Post> getPosts() {
		return posts;
	}
	public List<User> getFollowed() {
		return followed;
	}
	public List<User> getFollowers() {
		return followers;
	}
	public List<Comment> getComments() {
		return Comments;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setLocalisationCompany(String localisationCompany) {
		this.localisationCompany = localisationCompany;
	}
	public void setAdressUser(String adressUser) {
		this.adressUser = adressUser;
	}
	public void setPhoneNumberUser(int phoneNumberUser) {
		this.phoneNumberUser = phoneNumberUser;
	}
	public void setEnable(boolean isEnable) {
		this.isEnable = isEnable;
	}
	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}
	public void setSexeUser(SexeType sexeUser) {
		this.sexeUser = sexeUser;
	}
	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	public void setImageUser1(Set<ImageUser> imageUser1) {
		ImageUser1 = imageUser1;
	}
	public void setBusinesses(List<Business> businesses) {
		this.businesses = businesses;
	}
	public void setSalary(Salary salary) {
		this.salary = salary;
	}
	public void setWarn(Warn warn) {
		this.warn = warn;
	}
	public void setReunions(List<Reunion> reunions) {
		this.reunions = reunions;
	}
	public void setReunionsCompany(List<Reunion> reunionsCompany) {
		ReunionsCompany = reunionsCompany;
	}
	public void setDomain(Domain domain) {
		this.domain = domain;
	}
	public void setProfession(Profession profession) {
		this.profession = profession;
	}
	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	public void setFollowed(List<User> followed) {
		this.followed = followed;
	}
	public void setFollowers(List<User> followers) {
		this.followers = followers;
	}
	public void setComments(List<Comment> comments) {
		Comments = comments;
	}
	private int phoneNumberUser;
    private boolean isEnable;
    Long idCompany;
    @Enumerated(EnumType.STRING)
    private SexeType sexeUser;
    @ManyToMany(fetch = FetchType.EAGER )
    private Collection<Role> roles = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL)
    private Set<ImageUser> ImageUser1;



    /******************************************************WISSEM****************************************/
    @OneToMany(mappedBy="user")
    List<Business> businesses;
    @OneToOne
    Salary salary ;
    @OneToOne
    Warn warn;
    /******************************************************WISSEM****************************************/


    /******************************************************WAEL****************************************/
    @ManyToMany
    List<Reunion> reunions;
    @OneToMany (mappedBy="user")
    List<Reunion> ReunionsCompany;
    @ManyToOne
    Domain domain;
    @ManyToOne
    Profession profession;
    @OneToMany(mappedBy="user")
    List<Formation> formations;
    /******************************************************WAEL******************************************/

    /******************************************************lotfi******************************************/
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="users")
    private List<Post> posts;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="followed")
    private List<User> followed;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="followers")
    private List<User> followers;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy="users")
    private List<Comment> Comments;


    /******************************************************lotfi******************************************/
}
