package org.jsonatwork.ch4;

import static org.junit.Assert.*;

import java.io.*;
import java.net.*;
import java.util.*;

import org.junit.Test;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.type.*;

public class SpeakerJsonFlatFileTest {

	private static final String SPEAKER_JSON_FILE_NAME = "speaker.json";
	private static final String SPEAKERS_JSON_FILE_NAME = "speakers.json";
	private static final String TEST_SPEAKER_JSON = "{\n" + 
      "  \"id\" : 1,\n" + 
      "  \"age\" : 39,\n" + 
      "  \"fullName\" : \"Larson Richard\",\n" + 
      "  \"tags\" : [ \"JavaScript\", \"AngularJS\", \"Yeoman\" ],\n" + 
      "  \"registered\" : true\n" + 
    "}";

	@Test
	public void serializeObject() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			String[] tags = {"JavaScript", "AngularJS", "Yeoman"};
			Speaker speaker = new Speaker(1, 39, "Larson Richard", tags, true);
			String speakerStr = null;

			mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
			speakerStr = mapper.writeValueAsString(speaker);	
			System.out.println(speakerStr);
			assertTrue(TEST_SPEAKER_JSON.equals(speakerStr));
			assertTrue(true);
		} catch (JsonGenerationException jge) {
			jge.printStackTrace();
			fail(jge.getMessage());
		} catch (JsonMappingException jme) {
			jme.printStackTrace();
			fail(jme.getMessage());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			fail(ioe.getMessage());
		}
	}

	private File getSpeakerFile(String speakerFileName) throws URISyntaxException {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL fileUrl = classLoader.getResource(speakerFileName);
		URI fileUri = new URI(fileUrl.toString());
		File speakerFile = new File(fileUri);

		return speakerFile;
	}

	@Test
	public void deSerializeObject() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File speakerFile = getSpeakerFile(
										SpeakerJsonFlatFileTest.SPEAKER_JSON_FILE_NAME);

			Speaker speaker = mapper.readValue(speakerFile, Speaker.class);

			System.out.println("\n" + speaker + "\n");
			assertEquals("Larson Richard", speaker.getFullName());
			assertEquals(39, speaker.getAge());		
			assertTrue(true);
		} catch (URISyntaxException use) {
			use.printStackTrace();
			fail(use.getMessage());
		} catch (JsonParseException jpe) {
			jpe.printStackTrace();
			fail(jpe.getMessage());
		} catch (JsonMappingException jme) {
			jme.printStackTrace();
			fail(jme.getMessage());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			fail(ioe.getMessage());
		}
	}

	@Test
	public void deSerializeMultipleObjects() {
		try {
			ObjectMapper mapper = new ObjectMapper();
			File speakersFile = getSpeakerFile(
							SpeakerJsonFlatFileTest.SPEAKERS_JSON_FILE_NAME);

			JsonNode arrNode = mapper.readTree(speakersFile).get("speakers");
			List<Speaker> speakers = new ArrayList<Speaker>();
			if (arrNode.isArray()) {
			    for (JsonNode objNode : arrNode) {
			        System.out.println(objNode);
			        speakers.add(mapper.convertValue(objNode, Speaker.class));
			    }
			}

			assertEquals(3, speakers.size());
			System.out.println("\n\n\nAll Speakers\n");
			for (Speaker speaker: speakers) {
				System.out.println(speaker);
			}

			System.out.println("\n");
			Speaker speaker3 = speakers.get(2);
			assertEquals("Christensen Fisher", speaker3.getFullName());
			assertEquals(45, speaker3.getAge());	
			assertTrue(true);
		} catch (URISyntaxException use) {
			use.printStackTrace();
			fail(use.getMessage());
		} catch (JsonParseException jpe) {
			jpe.printStackTrace();
			fail(jpe.getMessage());
		} catch (JsonMappingException jme) {
			jme.printStackTrace();
			fail(jme.getMessage());
		} catch (IOException ioe) {
			ioe.printStackTrace();
			fail(ioe.getMessage());
		}
	}
}

