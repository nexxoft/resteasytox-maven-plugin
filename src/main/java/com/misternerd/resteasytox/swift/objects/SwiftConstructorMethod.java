package com.misternerd.resteasytox.swift.objects;

import java.util.ArrayList;

public class SwiftConstructorMethod extends SwiftMethod
{

	public SwiftConstructorMethod(ArrayList<SwiftProperty> properties, ArrayList<SwiftProperty> superProperties)
	{
		super(INIT_FUNCTION_NAME);

		for (SwiftProperty property : superProperties)
		{
			addParameter(property);
		}
		
		for (SwiftProperty property : properties)
		{
			addParameter(property);
			addBody(property.lineForConstructor());
		}
		
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("super.init(");
		
		for (SwiftProperty property : superProperties)
		{
			property.buildParameter(sb);
			
			// Add a comma for each element but the last.
			if (superProperties.indexOf(property) < superProperties.size() - 1)
			{
				sb.append(", ");
			}
		}
		
		sb.append(")");
		
		addBody(sb.toString());
		
	}

}
