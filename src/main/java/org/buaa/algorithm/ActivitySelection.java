package org.buaa.algorithm;

public class ActivitySelection
{
	private int activitiesNum = 0;//活动总数
	private Activity[] activities = null;//记录所有活动，包括虚拟活动

	public static void main(String[] args)
	{
		ActivitySelection sample = new ActivitySelection();
		sample.getInputInfo();
		System.out.println("活动选择结果：");
		sample.greedyActivitySelector();
	}

	public void greedyActivitySelector()
	{
		int i = 0;
		for (int m = 1; m <= this.activitiesNum; m++)
		{
			if (this.activities[m].start >= this.activities[i].end)
			{
				System.out.println(
						"id=" + this.activities[m].id + " start=" + this.activities[m].start + " end=" + this.activities[m].end);
				i = m;
			}
		}
	}

	public void getInputInfo()
	{
		this.activitiesNum = 11;
		System.out.println("活动总数:" + activitiesNum);
		activities = new Activity[this.activitiesNum + 1];
		int[] start = new int[]{1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12}, end =
				new int[]{4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
		activities[0] = new Activity(0, 0, 0);
		System.out.println("活动起止时间:");
		for (int i = 1; i <= this.activitiesNum; i++)
		{
			System.out.println("id:" + i + "\t" + start[i - 1] + "->" + end[i - 1]);
			activities[i] = new Activity(i, start[i - 1], end[i - 1]);
		}
	}

	public class Activity
	{
		private int id;
		private int start;
		private int end;

		public int getId()
		{
			return id;
		}

		public int getStart()
		{
			return start;
		}

		public int getEnd()
		{
			return end;
		}

		public Activity(int id, int start, int end)
		{
			this.id = id;
			this.start = start;
			this.end = end;
		}
	}
}