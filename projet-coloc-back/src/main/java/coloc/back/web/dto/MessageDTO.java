package coloc.back.web.dto;

public class MessageDTO {
	private Long emetteurId;
	private Long destinataireId;
	private String contenu;

	public MessageDTO() {
		super();
	}

	public MessageDTO(Long emetteurId, Long destinataireId, String contenu) {
		super();
		this.emetteurId = emetteurId;
		this.destinataireId = destinataireId;
		this.contenu = contenu;
	}
	
	public Long getEmetteurId(){
		return emetteurId;
	}

	public void setEmetteurId(Long emetteurId){
		this.emetteurId = emetteurId;
	}

	public Long getDestinataireId(){
		return destinataireId;
	}

	public void setDestinataireId(Long destinataireId){
		this.destinataireId = destinataireId;
	}

	public String getContenu(){
		return contenu;
	}

	public void setContenu(String contenu){
		this.contenu = contenu;
	}

}
