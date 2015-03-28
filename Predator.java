package PredatorPreySim;

import zen.core.Zen;

public class Predator {
int x, y, size, dx, dy;

	public Predator()
	{
		x = Zen.getRandomNumber(500);
		y = Zen.getRandomNumber(500);
		size = Zen.getRandomNumber(14, 16);
		dx = Zen.getRandomNumber(-5, 5);
		dy = Zen.getRandomNumber(-5, 5);
	}
	
	public Predator(int x, int y, int size, int dx, int dy)
	{
		this.x = x;
		this.y = y;
		this.size = size;
		this.dx = dx;
		this.dy = dy;
	}
	
	public void move()
	{
		x += dx + Zen.getRandomNumber(-2, 2);
		y += dy + Zen.getRandomNumber(-2, 2);
		
		if (x <= 0)
		{
			dx = Zen.getRandomNumber(3, 7);
		}
		if (x >= 480)
		{
			dx = Zen.getRandomNumber(-7, -3);
		}
		if (y <= 0)
		{
			dy = Zen.getRandomNumber(3, 7);
		}
		if (y >= 480)
		{
			dy = Zen.getRandomNumber(-7, -3);
		}
	}
	
	public void draw()
	{
		Zen.setColor("pink");
		Zen.fillOval(x, y, size, size);
	}
	
	public boolean isTouching(Prey p)
	{
		if (Math.abs(x - p.x) < size/2 && Math.abs(y - p.y) < size/2)
		{
			size += p.size/4;
			return true;
		}
		return false;
	}
	
	public boolean cannibalize(Predator p)
	{
		if (p !=this)
		{
				if (Math.abs(x - p.x) < size/2 && Math.abs(y - p.y) < size/2)
				{
					if (size < p.size)
					{
						return false;
					}
					size += p.size/4;
					return true;
				}
		}
		return false;
	}
}
