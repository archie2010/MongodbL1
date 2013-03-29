package com.archie.mongodb;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;

/**
 * ��ѯָ�����ݿ�ָ��DBCollection�����е���������
 * @author archie2010
 *
 * since 2012-9-29 ����10:40:21
 */
public class DBTest {
	public static void main(String[] args) throws UnknownHostException,
			MongoException {
		/**
		   Mongoʵ��������һ�����ݿ����ӳ�
		 * Mongo mg = new Mongo("localhost");
           Mongo mg = new Mongo("localhost", 27017);
		 */
		Mongo mg = new Mongo();
		// ��ѯ���е����ݿ�
		for (String name : mg.getDatabaseNames()) {
			System.out.println("DB Name: " + name);
		}

		// ��ȡ��Ϊ��dbtest�������ݿ����
		DB db = mg.getDB("dbtest");
		// ��ѯ�ÿ������еļ��� (�൱�ڱ�)
		for (String name : db.getCollectionNames()) {
			System.out.println("Collection Name: " + name);
		}
		DBCollection users = db.getCollection("emp");
		// ��ѯ���������е�����
		DBCursor cur = users.find();
		System.out.println("Record Count:" + cur.count());
		while (cur.hasNext()) {
			DBObject object = cur.next();
			System.out.println(object);
			// ȡ���������б�Ϊ�ֶ���Ϊ'uname'��'upwd'������
			System.out.println("uname:" + object.get("uname") + "\tupwd:"
					+ object.get("upwd"));
		}
	}
}