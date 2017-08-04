package com.zxc.DUS2.service;

import java.util.List;

import com.zxc.DUS2.dao.TreeDao;
import com.zxc.DUS2.dto.TreeDTO;
import com.zxc.DUS2.dto.TreeDTO2;
import com.zxc.DUS2.entities.Guomin;
import com.zxc.DUS2.entities.Xueke;



public class TreeService
{
	private TreeDao treeDao;

	public TreeDao getTreeDao()
	{
		return treeDao;
	}

	public void setTreeDao(TreeDao treeDao)
	{
		this.treeDao = treeDao;
	}
	public List<TreeDTO> getXuekeNodes(String id)
	{
		return treeDao.getXuekeNodes(id);
	}
	public List<Xueke> getXuekeAll()
	{
		return treeDao.getXuekeAll();
	}
	public List<TreeDTO2> getGuominNodes(String id)
	{
		return treeDao.getGuominNodes(id);
	}
	public List<Guomin> getGuominAll()
	{
		return treeDao.getGuominAll();
	}
}
