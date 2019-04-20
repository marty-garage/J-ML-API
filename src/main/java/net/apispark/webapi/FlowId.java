package net.apispark.webapi;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import net.apispark.webapi.representation.UploadDataset;
import net.apispark.webapi.representation.Usemodel;

@Embeddable
public class FlowId implements Serializable {

	public FlowId() {
		// TODO Auto-generated constructor stub
	}
	
	@Column(name="MLUsers_id")
	private UUID user;
	
	@OneToMany//(fetch = FetchType.LAZY)
	@JoinColumn(name="Usermodels_id") // table="review"
	private List<Usemodel> user_model;
	
	
	public List<Usemodel> getUser_model() {
		return user_model;
	}


	public void setUser_model(List<Usemodel> user_model) {
		this.user_model = user_model;
	}


	public List<UploadDataset> getUser_datasets() {
		return user_datasets;
	}


	public void setUser_datasets(List<UploadDataset> user_datasets) {
		this.user_datasets = user_datasets;
	}

	@OneToMany//(fetch = FetchType.LAZY)
	@JoinColumn(name="UploadDataset_id") // table="review"
	private List<UploadDataset> user_datasets;
	
	
	

}
