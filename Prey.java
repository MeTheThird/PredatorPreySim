package PredatorPreySim;

import zen.core.Zen;

public class Prey {
	int x, y, size, dx, dy;
	
	public Prey()
	{
		x = Zen.getRandomNumber(500);
		y = Zen.getRandomNumber(500);
		size = Zen.getRandomNumber(5, 8);
		dx = Zen.getRandomNumber(-5, 5);
		dy = Zen.getRandomNumber(-5, 5);
	}
	
	public Prey(int x, int y, int size, int dx, int dy)
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
				dx = Zen.getRandomNumber(1, 5);
			}
			if (x >= 500)
			{
				dx = Zen.getRandomNumber(-5, -1);
			}
			if (y <= 0)
			{
				dy = Zen.getRandomNumber(1, 5);
			}
			if (y >= 500)
			{
				dy = Zen.getRandomNumber(-5, -1);
			}
	}
	
	public void draw()
	{
		Zen.setColor("blue");
		Zen.fillOval(x, y, size, size);
	}
}
