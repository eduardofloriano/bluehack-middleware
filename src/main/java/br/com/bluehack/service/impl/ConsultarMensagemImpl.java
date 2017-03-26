package br.com.bluehack.service.impl;
 
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;

import br.com.bluehack.service.IConsultarMensagem;
import br.com.bluehack.service.sei.ConsultarMensagemResponse;
import br.com.bluehack.util.JsonUtil;
import br.com.bluehack.watson.service.WatsonConversationService;
 
@Path("/ConsultarMensagem")
public class ConsultarMensagemImpl implements IConsultarMensagem {
 
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{pergunta}")
	public MessageResponse sayHello( @PathParam(value = "pergunta") String pergunta) {
		
		WatsonConversationService service = new WatsonConversationService();
		MessageResponse response = service.enviarMensagem(pergunta);
		return response;
		
	}
 
}