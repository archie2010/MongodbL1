package com.archie.mongodb;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;

/**
 * ��ָ��DBCollection���ϵ�CRUD����
 * @author archie2010
 *
 * since 2012-9-29 ����10:51:24
 */
public class CRUDTest {
	/**
	 * ����
	 * @param obj
	 */
	public static void add(DBObject obj){
		DBCollection coll=DBUtil.getDBCollection("dbtest", "emp");
		coll.insert(obj);
	}
	/**
	 * ɾ��
	 * @param obj
	 */
	public static void delete(DBObject obj){
		DBCollection coll=DBUtil.getDBCollection("dbtest", "emp");
		coll.remove(obj);
	}
	/**
	 * ��ѯ
	 */
	public static void query(){
		DBCollection coll=DBUtil.getDBCollection("dbtest", "emp");
		// ��ѯ���������е�����
		DBCursor cur = coll.find();
		System.out.println("Record Count:" + cur.count());
		while (cur.hasNext()) {
			DBObject object = cur.next();
			System.out.println(object);
			// ȡ���������б�Ϊ'uname'��'upwd'������
			System.out.println("uname:" + object.get("uname") + "\tupwd:"
					+ object.get("upwd")+"\t_id:"+object.get("_id"));
		}
	}
	/**
	 * �޸�
	 */
	public static void modify(DBObject orig,DBObject update){
		DBCollection coll=DBUtil.getDBCollection("dbtest", "emp");
		coll.update(orig, update, true, false);
	}
	public static void main(String[] args) {
		DBObject empObj=new BasicDBObject();
		empObj.put("uname", "teddy");
		empObj.put("upwd", "123456");
		//���
		add(empObj);
		query();
		
		
		DBObject updateObj=new BasicDBObject();
		updateObj.put("uname", "teddy");
		updateObj.put("upwd", "3333");
		//����
		modify(new BasicDBObject("uname","teddy"),updateObj);
		System.out.println("-----------------------�޸ĺ�-------------------");
		query();
		
		//ɾ��
		delete(new BasicDBObject("uname","teddy"));
		System.out.println("-----------------------ɾ����-------------------");
		query();
	}
}
