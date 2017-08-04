package com.zxc.DUS2.entities;

/**
 * Xueke entity. @author MyEclipse Persistence Tools
 */

public class Xueke implements java.io.Serializable
{

	// Fields

	private String code;
	private String title;

	// Constructors

	/** default constructor */
	public Xueke()
	{
	}

	/** minimal constructor */
	public Xueke(String code)
	{
		this.code = code;
	}

	/** full constructor */
	public Xueke(String code, String title)
	{
		this.code = code;
		this.title = title;
	}

	// Property accessors

	public String getCode()
	{
		return this.code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

}