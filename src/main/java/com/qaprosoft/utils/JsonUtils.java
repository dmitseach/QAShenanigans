package com.qaprosoft.utils;

import org.apache.commons.lang.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * This is the utility class for JSON Objects
 */
public final class JsonUtils
{	
	/**
	 * Add or change(if value will be found) 
	 * 
	 * @param key
	 *            key to find value in JSON in format like param.param1[2].param.string()
	 *            
	 * @param value
	 *            new value to set
	 *            
	 * @param jsonObject
	 *            JSON where key should be found
	 *            
	 * @return the {@link JSONObject} 
	 * 			  new JSON object that will be generated
	 * 
	 * @throws RuntimeException
	 * 			  when key is empty, not valid or can't find value
	 */
	@SuppressWarnings("unchecked")
	public static JSONObject addOrChangeJSONValue(String key, String value, JSONObject jsonObject)
	{		
	    String[] keys = key.split("\\.");
	    if(keys.length == 2)
	    {
	    	if(keys[0].contains("["))
	    	{
	    		String currentKey = StringUtils.substringBefore(keys[0], "[");
		    	int arrayIndex = Integer.valueOf(StringUtils.substringBetween(keys[0], "[", "]"));
		    	JSONArray array = jsonObject.get(currentKey) == null ? new JSONArray() : (JSONArray) jsonObject.get(currentKey);		    	
		    	if(arrayIndex < array.size()) array.remove(arrayIndex);
		    	switch(keys[1])
		    	{
		    		case "int()":	    			
		    			array.add(arrayIndex, Integer.valueOf(value).intValue()); break;
		    		case("double()"): 
		    			array.add(arrayIndex, Integer.valueOf(value).intValue()); break;
		    		default: array.add(arrayIndex, value); break;
		    	}		    	
		    	jsonObject.put(currentKey, array);
		    	return jsonObject;
	    	}
	    	if(StringUtils.isBlank(value))
	    	{
	    		jsonObject.put(keys[0], value);
	    		return jsonObject;
	    	}
	    	switch(keys[1])
	    	{
	    		case "int()":	    			
	    			jsonObject.put(keys[0], Integer.valueOf(value).intValue()); break;
	    		case("double()"): 
	    			jsonObject.put(keys[0], Integer.valueOf(value).intValue()); break;
	    		default: jsonObject.put(keys[0], value); break;
	    	}
	    	return jsonObject;
	    } else if(keys.length > 2)
	    {
	    	String currentKey = StringUtils.substringBefore(keys[0], "[");
	    	String arrayIndex = StringUtils.substringBetween(keys[0], "[", "]");
	    	if(StringUtils.isEmpty(arrayIndex))
	    	{	    		
	    		JSONObject currJSON = jsonObject.get(currentKey) == null ? new JSONObject() : (JSONObject) jsonObject.get(currentKey);
	    		JSONObject newJson = addOrChangeJSONValue(StringUtils.substringAfter(key, "."), value, currJSON);
	    		jsonObject.put(currentKey, newJson);
	    		return jsonObject;
	    	} else
	    	{
	    		int index = Integer.valueOf(arrayIndex).intValue();
	    		JSONArray array = jsonObject.get(currentKey) == null ? new JSONArray() : (JSONArray) jsonObject.get(currentKey);	    		
	    		JSONObject arrayObject = array.isEmpty() || index >= array.size() ? new JSONObject() : (JSONObject) array.get(index);
	    		JSONObject newJson = addOrChangeJSONValue(StringUtils.substringAfter(key, "."), value, arrayObject);
	    		if(index < array.size()) array.remove(index);
	    		if(array.size() < index)
	    		{
	    			array.add(newJson);
	    		} else 
	    		{
	    			array.add(index, newJson);
	    		}
	    		jsonObject.put(currentKey, array);
	    		return jsonObject;
	    	}
	    } else throw new RuntimeException("Key is empty! Key " + key);
	}	
	
	/**
	 * Get value from JSON object 
	 * 
	 * @param key
	 *            key to find value in JSON in format like param.param1[2].param
	 *                        
	 * @param jsonObject
	 *            JSON where key should be found
	 *            
	 * @param isRequired
	 * 			  should JSON contains this key, if YES - will throw an Exception, if can't find
	 * 			  if NO - will return null
	 *            
	 * @return the {@link Object} 
	 * 			  value for the key
	 * 
	 * @throws RuntimeException
	 * 			  when key is empty, not valid or can't find value
	 */
	public static Object getJSONValue(String key, JSONObject jsonObject, boolean isRequired)
	{		
	    String[] keys = key.split("\\.");
	    if(keys.length == 1)
	    {
	    	String currentKey = StringUtils.substringBefore(keys[0], "[");
	    	String arrayIndex = StringUtils.substringBetween(keys[0], "[", "]");
	    	if(StringUtils.isEmpty(arrayIndex))
	    	{
	    		return jsonObject.get(keys[0]);
	    	}
	    	else 
	    	{
	    		int index = Integer.valueOf(arrayIndex).intValue();	
	    		JSONArray array = (JSONArray) jsonObject.get(currentKey);	    		
	    		if(array.isEmpty() || array.size() <= index || array.get(index) == null) 
	    		{
	    			if(isRequired)
	    			{
	    				throw new RuntimeException("No arrays element found for key: " + currentKey + " and index: " + arrayIndex);
	    			} else 
	    			{
	    				return null;
	    			}
	    		}
	    		return array.get(index);
	    	}
	    } else if(keys.length > 1)
	    {
	    	String currentKey = StringUtils.substringBefore(keys[0], "[");
	    	String arrayIndex = StringUtils.substringBetween(keys[0], "[", "]");
	    	if(StringUtils.isEmpty(arrayIndex))
	    	{	    		
	    		if(jsonObject.get(currentKey) == null)
	    		{	
	    			if(isRequired)
	    			{
	    				throw new RuntimeException("No objects found for key: " + currentKey);
	    			} else 
	    			{
	    				return null;
	    			}
	    		}
	    		return getJSONValue(StringUtils.substringAfter(key, "."), (JSONObject) jsonObject.get(currentKey), isRequired);
	    	} else
	    	{
	    		int index = Integer.valueOf(arrayIndex).intValue();	    		
	    		if(jsonObject.get(currentKey) == null)
	    		{
	    			if(isRequired)
	    			{
	    				throw new RuntimeException("No arrays found for key: " + currentKey);
	    			} else
	    			{
	    				return null;
	    			}
	    		}
	    		JSONArray array = (JSONArray) jsonObject.get(currentKey);	    		
	    		if(array.isEmpty() || array.size() <= index || array.get(index) == null) 
	    		{
	    			if(isRequired)
	    			{
	    				throw new RuntimeException("No arrays element found for key: " + currentKey + " and index: " + arrayIndex);
	    			} else 
	    			{
	    				return null;
	    			}
	    		}
	    		JSONObject arrayObject = (JSONObject) array.get(index);
	    		return getJSONValue(StringUtils.substringAfter(key, "."), arrayObject, isRequired);	    		
	    	}
	    } else throw new RuntimeException("Key is empty!");
	}
	
	/**
	 * Remove value from JSON object 
	 * 
	 * @param key
	 *            key to remove value in JSON in format like param.param1[2].param
	 *                        
	 * @param jsonObject
	 *            JSON where key should be found
	 *
	 * @param isRequired
	 * 			  should JSON contains this key, if YES - will throw an Exception, if can't find
	 * 			  if NO - will return null
	 * 
	 * @throws RuntimeException
	 * 			  when key is empty, not valid or can't find value
	 */
	public static void removeJSONValue(String key, JSONObject jsonObject, boolean isRequired)
	{		
	    String[] keys = key.split("\\.");
	    if(keys.length == 1)
	    {
	    	String currentKey = StringUtils.substringBefore(keys[0], "[");
	    	String arrayIndex = StringUtils.substringBetween(keys[0], "[", "]");
	    	if(StringUtils.isEmpty(arrayIndex))
	    	{
	    		jsonObject.remove(keys[0]);
	    	}
	    	else 
	    	{
	    		int index = Integer.valueOf(arrayIndex).intValue();	
	    		JSONArray array = (JSONArray) jsonObject.get(currentKey);	    		
	    		if(array.isEmpty() || array.size() <= index || array.get(index) == null) 
	    		{	
	    			if(isRequired)
	    			{
	    				throw new RuntimeException("No arrays element found for key: " + currentKey + " and index: " + arrayIndex);
	    			} else
	    			{
	    				return;
	    			}
	    		}
	    		array.remove(index);
	    	}
	    } else if(keys.length > 1)
	    {
	    	String currentKey = StringUtils.substringBefore(keys[0], "[");
	    	String arrayIndex = StringUtils.substringBetween(keys[0], "[", "]");
	    	if(StringUtils.isEmpty(arrayIndex))
	    	{	    		
	    		if(jsonObject.get(currentKey) == null)
	    		{
	    			if(isRequired)
	    			{
	    				throw new RuntimeException("No objects found for key: " + currentKey);
	    			} else
	    			{
	    				return;
	    			}
	    		}
	    		removeJSONValue(StringUtils.substringAfter(key, "."), (JSONObject) jsonObject.get(currentKey), isRequired);
	    	} else
	    	{
	    		int index = Integer.valueOf(arrayIndex).intValue();	    		
	    		if(jsonObject.get(currentKey) == null)
	    		{
	    			if(isRequired)
	    			{
	    				throw new RuntimeException("No arrays found for key: " + currentKey);
	    			} else 
	    			{
	    				return;
	    			}
	    		}
	    		JSONArray array = (JSONArray) jsonObject.get(currentKey);	    		
	    		if(array.isEmpty() || array.size() <= index || array.get(index) == null) 
	    		{
	    			if(isRequired)
	    			{
	    				throw new RuntimeException("No arrays element found for key: " + currentKey + " and index: " + arrayIndex);
	    			} else
	    			{
	    				return;
	    			}
	    		}
	    		JSONObject arrayObject = (JSONObject) array.get(index);
	    		removeJSONValue(StringUtils.substringAfter(key, "."), arrayObject, isRequired);	    		
	    	}
	    } else throw new RuntimeException("Key is empty!");
	}
}
