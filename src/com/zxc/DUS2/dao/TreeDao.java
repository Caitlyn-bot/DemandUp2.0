package com.zxc.DUS2.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.zxc.DUS2.dto.TreeDTO;
import com.zxc.DUS2.dto.TreeDTO2;
import com.zxc.DUS2.entities.Guomin;
import com.zxc.DUS2.entities.Xueke;

public class TreeDao extends BaseDao
{
	public List<TreeDTO> getXuekeNodes(String id)
	{
		List<Xueke> xuekeList = new ArrayList<Xueke>();
		String hql;

		if ("".equals(id) || id == null)
		{
			hql = "from Xueke x where x.code like '%00000'";
			xuekeList = getSession().createQuery(hql).list();
		} else if (id.length() == 2)
		{
			hql = "from Xueke x where x.code like '" + id
					+ "%00' and x.code != '" + id + "00000'";
			xuekeList = getSession().createQuery(hql).list();
		} else if (id.length() == 5)
		{
			hql = "from Xueke x where x.code like '" + id
					+ "%' and x.code != '" + id + "00'";
			xuekeList = getSession().createQuery(hql).list();
		}

		List<TreeDTO> tlist = new ArrayList<TreeDTO>();
		for (Iterator iterator = xuekeList.iterator(); iterator.hasNext();)
		{
			Xueke xueke = (Xueke) iterator.next();
			TreeDTO tree = new TreeDTO();
			if ("".equals(id) || id == null)
			{
				tree.setId(Integer.valueOf(xueke.getCode().substring(0, 2)));// 2
			} else if (id.length() == 2)
			{
				tree.setId(Integer.valueOf(xueke.getCode().substring(0, 5)));// 5
			} else if (id.length() == 5)
			{
				tree.setId(Integer.valueOf(xueke.getCode()));// all
			}
			tree.setText(xueke.getTitle());
			tree.setChecked(0);
			tree.setIconCls("icon-none");
		
			if ("".equals(id) || id == null || id.length() == 2)
			{
				tree.setState("closed");
			}

			/*
			 * Map<String, Object> map = new HashMap<String, Object>();
			 * map.put("url", XKFL.getUrl()); tree.setAttributes(map);
			 */
			tlist.add(tree);
		}
		return tlist;
	}

	public List<Xueke> getXuekeAll()
	{
		String hql = "from Xueke x where x.code like '%00000'";
		return getSession().createQuery(hql).list();
	}

	public List<TreeDTO2> getGuominNodes(String id)
	{
		List<Guomin> guominList = new ArrayList<Guomin>();
		String hql;

		if ("".equals(id) || id == null)
		{
			hql = "from Guomin g where g.code like '%0000'";
			guominList = getSession().createQuery(hql).list();
		} else if (id.length() == 1)
		{
			hql = "from Guomin g where g.code like '" + id
					+ "%00' and g.code != '" + id + "0000'";
			guominList = getSession().createQuery(hql).list();
		} else if (id.length() == 3)
		{
			hql = "from Guomin g where g.code like '" + id
					+ "%' and g.code != '" + id + "00'";
			guominList = getSession().createQuery(hql).list();
		}

		List<TreeDTO2> tlist = new ArrayList<TreeDTO2>();
		for (Iterator iterator = guominList.iterator(); iterator.hasNext();)
		{
			Guomin guomin = (Guomin) iterator.next();
			TreeDTO2 tree = new TreeDTO2();
			if ("".equals(id) || id == null)
			{
				tree.setId(guomin.getCode().substring(0, 1));// 1
			} else if (id.length() == 1)
			{
				tree.setId(guomin.getCode().substring(0, 3));//3
			} else if (id.length() == 3)
			{
				tree.setId(guomin.getCode());// all
			}
			tree.setText(guomin.getTitle());
			tree.setChecked(0);
			tree.setIconCls("icon-none");
			if ("".equals(id) || id == null || id.length() == 1)
			{
				tree.setState("closed");
			}

			/*
			 * Map<String, Object> map = new HashMap<String, Object>();
			 * map.put("url", XKFL.getUrl()); tree.setAttributes(map);
			 */
			tlist.add(tree);
		}
		return tlist;
	}

	public List<Guomin> getGuominAll()
	{
		String hql = "from Guomin g where g.code like '%0000'";
		return getSession().createQuery(hql).list();
	}
}
