//package br.com.bluehack.watson.service.test;
//import org.apache.commons.lang3.StringUtils;
//import org.junit.Test;
//
//import com.ibm.watson.developer_cloud.conversation.v1.ConversationService;
//import com.ibm.watson.developer_cloud.conversation.v1.model.Entity;
//import com.ibm.watson.developer_cloud.conversation.v1.model.Intent;
//import com.ibm.watson.developer_cloud.conversation.v1.model.MessageRequest;
//import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
//import com.ibm.watson.developer_cloud.http.HttpHeaders;
//
//public class ConversationServiceTest {
//
//	private ConversationService service;
//	private static final String FIXTURE = "src/test/resources/conversation/conversation.json";
//	private static final String WORKSPACE_ID = "123";
//	private static final String PATH_MESSAGE = "/v1/workspaces/" + WORKSPACE_ID	+ "/message";
//	private static final String EMPTY = "";
//	private static final String VERSION = "version";
//
//	@Test
//	public void callSucesso() {
//		
//		service = new ConversationService(ConversationService.VERSION_DATE_2017_02_03);
//	    service.setApiKey(EMPTY);
//	    service.setEndPoint(getMockWebServerUrl());
//		
//		
//
//		String text = "I'd like to get insurance to for my home";
//
//		MessageResponse mockResponse = loadFixture(FIXTURE,
//				MessageResponse.class);
//		server.enqueue(jsonResponse(mockResponse));
//
//		MessageRequest options = new MessageRequest.Builder().inputText(text)
//				.intent(new Intent("turn_off", 0.0))
//				.entity(new Entity("car", "ford", null)).alternateIntents(true)
//				.build();
//
//		// execute first request
//		MessageResponse serviceResponse = service
//				.message(WORKSPACE_ID, options).execute();
//
//		// first request
//		RecordedRequest request = server.takeRequest();
//
//		String path = StringUtils.join(PATH_MESSAGE, "?", VERSION, "=",
//				ConversationService.VERSION_DATE_2017_02_03);
//		assertEquals(path, request.getPath());
//		assertArrayEquals(new String[] { "Do you want to get a quote?" },
//				serviceResponse.getText().toArray(new String[0]));
//		assertEquals("Do you want to get a quote?",
//				serviceResponse.getTextConcatenated(" "));
//		assertEquals(request.getMethod(), "POST");
//		assertNotNull(request.getHeader(HttpHeaders.AUTHORIZATION));
//		assertEquals(
//				"{\"alternate_intents\":true,\"entities\":[{\"entity\":\"car\",\"value\":\"ford\"}],"
//						+ "\"input\":{\"text\":\"I'd like to get insurance to for my home\"},\"intents\":"
//						+ "[{\"confidence\":0.0,\"intent\":\"turn_off\"}]}",
//				request.getBody().readUtf8());
//		assertEquals(serviceResponse, mockResponse);
//
//	}
//
//}
