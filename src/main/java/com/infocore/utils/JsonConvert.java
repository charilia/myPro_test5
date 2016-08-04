/*
 * Copyright (C), 2002-2014, �����׹������������޹�˾
 * FileName: JsonConvert.java
 * Author:   Administrator
 * Date:     2014-10-14 ����8:34:15
 * Description: //ģ��Ŀ�ġ���������      
 * History: //�޸ļ�¼
 * <author>      <time>      <version>    <desc>
 * �޸�������             �޸�ʱ��            �汾��                  ����
 */
package com.infocore.utils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.jboss.logging.Logger;
import org.springframework.util.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;

/**
 * jsonת����
 */
public class JsonConvert {

	private static final ObjectMapper MPPER = new ObjectMapper();

	private static final Logger LOGGER = LoggerFactory
			.logger(JsonConvert.class);

	public static Gson gson = new GsonBuilder()
			.enableComplexMapKeySerialization().create();

	private JsonConvert() {
	}

	/**
	 * json ת��Ϊ ����
	 * 
	 * @param json
	 *            json��
	 * @param cl
	 *            ����
	 * @return
	 * @see [�����/����](��ѡ)
	 * @since [��Ʒ/ģ��汾](��ѡ)
	 */
	public static <T> T jsonToObject(String json, Class<T> cl) {
		LOGGER.info("Enter method jsonToObject");

		LOGGER.info("param=" + json);
		try {
			return MPPER.readValue(json.getBytes("UTF-8"), cl);
		} catch (JsonParseException e) {
			LOGGER.error("JsonParseException", e);
		} catch (JsonMappingException e) {
			LOGGER.error("JsonMappingException", e);
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("UnsupportedEncodingException", e);
		} catch (IOException e) {
			LOGGER.error("IOException", e);
		}
		LOGGER.info("Exit method jsonToObject");
		return null;
	}

	public static <T> T jsonToObject(String json, TypeReference<T> cl) {
		LOGGER.info("Enter method jsonToObject1");
		LOGGER.info("param=" + json);
		try {
			return MPPER.readValue(json, cl);
		} catch (Exception e) {
			LOGGER.error("jsonToObject1 occur Exception", e);
		}
		LOGGER.info("Exit method jsonToObject");
		return null;
	}

	/**
	 * Listת��ΪJSON��ʽ��String
	 * 
	 * @param t
	 *            ����
	 * @return
	 * @see [�����/����](��ѡ)
	 * @since [��Ʒ/ģ��汾](��ѡ)
	 */
	public static <T> List<T> setToList(Set<String> msgList, Class<?> t) {

		// ��У��
		if (null == msgList) {
			return Collections.emptyList();
		}

		List<T> list = new ArrayList<T>();
		// ת��Ϊ����
		for (String msg : msgList) {
			list.add((T) JsonConvert.jsonToObject(msg, t));
		}
		return list;
	}

	/**
	 * Listת��ΪJSON��ʽ��String
	 * 
	 * @param t
	 *            ����
	 * @return
	 * @see [�����/����](��ѡ)
	 * @since [��Ʒ/ģ��汾](��ѡ)
	 */
	public static <T> String[] listoString(List<T> t) {

		String[] temp = new String[t.size()];

		for (int i = 0; i < t.size(); i++) {
			temp[i] = objectoJson(t.get(i));
		}

		return temp;
	}

	/**
	 * ����ת��Ϊjson
	 * 
	 * @param obj
	 *            ��Ҫת������
	 * @return ת�����json��
	 * @see [�����/����](��ѡ)
	 * @since [��Ʒ/ģ��汾](��ѡ)
	 */
	public static String objectoJson(Object obj) {
		LOGGER.debug("Enter method objectoJson");
		try {
			return MPPER.writeValueAsString(obj);
		} catch (JsonGenerationException e) {
			LOGGER.error("JsonGenerationException", e);
		} catch (JsonMappingException e) {
			LOGGER.error("JsonMappingException", e);
		} catch (IOException e) {
			LOGGER.error("IOException", e);
		}
		LOGGER.debug("Exit method objectoJson");
		return null;
	}

	/**
	 * 
	 * ��������: ���jsonp�ķ��ظ�ʽ<br>
	 * ��������ϸ������
	 * 
	 * @param obj
	 * @return
	 * @see [�����/����](��ѡ)
	 * @since [��Ʒ/ģ��汾](��ѡ)
	 */
	public static String packageJsonpCallback(String callback, Object obj) {
		if (StringUtils.isEmpty(callback)) {
			return gson.toJson(obj);
		}
		return callback + "(" + gson.toJson(obj) + ")";
	}
}
