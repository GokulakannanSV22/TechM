package com.assessment2.app;
public class Associate 
{
	private int associate_id;
	private String associate_name;
	private String work_status;
	
	public Associate()
	{
		
	}
	/**
	 * setting Associate Name
	 * @param associate_id
	 */
	public void setAssociate_id(int associate_id)
	{
		this.associate_id = associate_id;
	}
	public int getAssociate_id()
	{
		return this.associate_id;
	}
	/**
	 * setting Associate name
	 * @param associate_name
	 */
	
	public void setAssociate_name(String associate_name)
	{
		this.associate_name = associate_name;
	}
	public String getAssociate_name()
	{
		return this.associate_name;
	}
	
	/**
	 * setting Associate WorkStatus
	 * @param work_status
	 */
	public void setWork_status(String work_status)
	{
		this.work_status = work_status;
	}
	public String getWork_status()
	{
		return this.work_status;
	}
	
	/**
	 * to track the status of the Associate
	 * @param no_of_days
	 */
	public void trackAssociateStatus(int no_of_days)
	{
		if(no_of_days<=20)
		{
			setWork_status("Associate is Learning Core Skills...");
		}
		else if(no_of_days>20 && no_of_days<=40)
		{
			setWork_status("Associate is Learning Advanced Modules...");
		}
		else if(no_of_days>40 && no_of_days<=60)
		{
		    setWork_status("Associate is in project phase...");
		}
		else
		{
			setWork_status("Deployed in Project...");
		}
	}
	
	
	
public static void main(String [] args)
{
	Associate A1 = new Associate();
	
	A1.setAssociate_id(5);
	A1.setAssociate_name("Monk");
	A1.trackAssociateStatus(40);
	System.out.println("Associate ID:");
	System.out.println(A1.getAssociate_id());
	System.out.println("Associate Name:");
	System.out.println(A1.getAssociate_name());
	System.out.println("Associate WorkStatus:");
	System.out.println(A1.getWork_status());
	
	
}
}
