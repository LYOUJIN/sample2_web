/*****************************************************************************
 * Copyright(c) 2014 neonexsoft. All rights reserved.
 * This software is the proprietary information of neonexsoft.
 * <p/>
 * Description :
 * Create on 2017-05-11 **
 *****************************************************************************/
package com.sample.web.common.config;


import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.io.IOException;
import java.util.Properties;

public class ConstantStore extends PropertyPlaceholderConfigurer
{

	
	private Properties mergedProperties = null;
	
	public Properties getMergedProperties()
	{
		try
		{
			if (this.mergedProperties == null) {
				this.mergedProperties = mergeProperties();
			}
		}
		catch (IOException e)
		{
			this.logger.error(e.getMessage(), e);
		}
		return this.mergedProperties;
	}

	public String getValue(String key)
	{
		if (this.mergedProperties == null) {
			this.mergedProperties = getMergedProperties();
		}
		return this.mergedProperties.getProperty(key);
	}

	public int getIntValue(String key)
	{
		if (this.mergedProperties == null) {
			this.mergedProperties = getMergedProperties();
		}
		return Integer.valueOf(this.mergedProperties.getProperty(key)).intValue();
	}

	public long getLongValue(String key)
	{
		if (this.mergedProperties == null) {
			this.mergedProperties = getMergedProperties();
		}
		return Long.valueOf(this.mergedProperties.getProperty(key)).longValue();
	}
	
	public boolean getBooleanValue(String key)
	{
		if (this.mergedProperties == null) {
			this.mergedProperties = getMergedProperties();
		}
		return Boolean.valueOf(this.mergedProperties.getProperty(key)).booleanValue();
	}
	
	
}
