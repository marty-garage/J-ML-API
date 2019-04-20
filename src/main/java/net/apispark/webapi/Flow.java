package net.apispark.webapi;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import net.apispark.webapi.representation.UploadDataset;
import net.apispark.webapi.representation.Usemodel;


@Entity(name="Flows")
public class Flow implements Serializable{
	
	@EmbeddedId
	private FlowId id;
	
	private String Name;

	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	/*
	 * @OneToOne(fetch = FetchType.LAZY)
	 * 
	 * @MapsId private MLUser user;
	 */
	
	
	
	
	
	public Flow() {
		// TODO Auto-generated constructor stub
	}

}
