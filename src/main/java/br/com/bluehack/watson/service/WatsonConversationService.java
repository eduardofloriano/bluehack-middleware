package br.com.bluehack.watson.service;

import java.util.HashMap;
import java.util.Map;

import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
import com.ibm.watson.developer_cloud.conversation.v1.model.Intent;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.http.HttpHeaders;

public class WatsonConversationService {

	private static final String URL = "https://gateway.watsonplatform.net/conversation/api";
	private static final String USERNAME = "6904e86f-6e17-4c4f-84ab-1cb77ce8aa64";
	private static final String PASSWORD = "MWZgI4t7WO28";
	private static final String WORKSPACE_ID = "711d2959-fbcf-4f15-9648-172693ee8893";

	public MessageResponse enviarMensagem(String message) {

		ConversationService service = new ConversationService(
				ConversationService.VERSION_DATE_2016_09_20);
		service.setEndPoint(URL);
		service.setUsernameAndPassword(USERNAME, PASSWORD);
		service.setDefaultHeaders(getDefaultHeaders());

		Map<String, Object> context = null;
		MessageRequest request = new MessageRequest.Builder().inputText(message).alternateIntents(true).context(context)
				.build();

		if (message.equals("yes")) {
			request = request.newBuilder().intent(new Intent("off_topic", 1.0))
					.build();
		}

		MessageResponse response = service.message(WORKSPACE_ID, request).execute();
		return response;
	}

	private Map<String, String> getDefaultHeaders() {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put(HttpHeaders.X_WATSON_LEARNING_OPT_OUT, String.valueOf(true));
		headers.put(HttpHeaders.X_WATSON_TEST, String.valueOf(true));
		return headers;
	}

}
