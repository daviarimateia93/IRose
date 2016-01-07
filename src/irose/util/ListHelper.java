package irose.util;

import java.util.List;

public class ListHelper
{
	public static <T> T get(List<T> list, Object element)
	{
		int index = list.indexOf(element);
		
		return index != -1 ? list.get(index) : null;
	}
}
