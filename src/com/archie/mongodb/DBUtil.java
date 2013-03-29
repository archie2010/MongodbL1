package com.archie.mongodb;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;

/**
 * ���DBCollection���ϵĹ�����
 * @author archie2010
 *
 * since 2012-9-29 ����10:54:42
 */
public class DBUtil {

	public static Mongo mg=null;    
	public static DB db=null;    
	public static DBCollection collection;
	
	/**
	 * ���DBCollection����
	 * @param dbName
	 * @param colName
	 * @return
	 */
	public static DBCollection getDBCollection(String dbName,String colName){
		if(mg==null){
			try {
				mg=new Mongo();
			} catch (UnknownHostException e) {
				e.printStackTrace();
			}
		}
		if(db==null){
			db=mg.getDB(dbName);
		}
		return db.getCollection(colName);
	}
}
