package com.chinamobile.cmti.editors;

import java.beans.PropertyEditorSupport;

import com.chinamobile.cmti.model.ProvinceVO;

public class DepartmentEditor extends PropertyEditorSupport
{
    @Override
    public void setAsText(String id) 
    {
    	ProvinceVO d;
    	switch(Integer.parseInt(id))
		{
			case 1: d = new ProvinceVO(1,  "Human Resource"); break;
			case 2: d = new ProvinceVO(2,  "Finance"); break;
			case 3: d = new ProvinceVO(3,  "Information Technology"); break;
			default: d = null;
		}
        this.setValue(d);
    }
}
