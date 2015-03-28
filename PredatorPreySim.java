package PredatorPreySim;

import java.util.ArrayList;

import zen.core.Zen;

public class PredatorPreySim {
	
	static ArrayList<Prey> prey = new ArrayList<Prey>();
	static ArrayList<Predator> predators = new ArrayList<Predator>();

	public static void main(String[] args) 
	{
		Zen.create(1000, 1000);
		
		for (int i = 0; i < 10000; i++)
		{
			prey.add(new Prey());
		}
		
		for (int i = 0; i < 1; i++)
		{
			predators.add(new Predator());
		}
		
		while (true)
		{
			Zen.setBackground("white");
			
			for (int i = 0; i < prey.size(); i++)
			{
				prey.get(i).draw();
				prey.get(i).move();
			}
			
			for (int i = 0; i < predators.size(); i++)
			{
				predators.get(i).draw();
				predators.get(i).move();
			}
			
			for (int i = 0; i < predators.size(); i++)
			{
				for (int j = 0; j < prey.size(); j++)
				{
					if (predators.get(i).isTouching(prey.get(j)))
					{
						prey.remove(j);
					}
				}
			}
			for (int i = 0; i < predators.size(); i++)
			{
				for (int j = 0; j < predators.size(); j++)
				{
					if (predators.get(i).cannibalize(predators.get(j)))
					{
						predators.remove(j);
					}
				}
			}
			
			Zen.buffer(33);
		}
		
	}

}
