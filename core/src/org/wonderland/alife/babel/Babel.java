package org.wonderland.alife.babel;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import org.wonderland.alife.babel.engine.DNAUtils;
import org.wonderland.alife.babel.engine.Engine;
import org.wonderland.alife.babel.engine.Globals;
import org.wonderland.alife.babel.engine.entities.Cell;

import java.util.Random;


public class Babel extends ApplicationAdapter {
	Random random = new Random(System.nanoTime());
	SpriteBatch batch;
	//Texture img;
	//OrthographicCamera camera;
	ShapeRenderer shapeRenderer;
	BitmapFont font;
	@Override
	public void create () {
		shapeRenderer = new ShapeRenderer();
		//camera = new OrthographicCamera(300, 480);
		batch = new SpriteBatch();
		font = new BitmapFont();
		font.getData().setScale(3.25f, 3.25f);
		//img = new Texture("badlogic.jpg");
	}

	@Override
	public void render () {
		Engine.INSTANCE.initEngine(random.nextInt(100));
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//Gdx.gl.glEnable(GL20.GL_BLEND);
		//Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
		//Gdx.gl.glDisable(GL20.GL_BLEND);

		//batch.setProjectionMatrix(camera.combined);
		batch.begin();
		//camera.update();
		//shapeRenderer.setProjectionMatrix(camera.combined);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);




		for(Cell cell : Engine.INSTANCE.cells) {

			String binDNA = DNAUtils.getDnaAsBits(cell);
			float r = Integer.parseInt(binDNA.substring(0, 8), 2) / 255f;
			float g = Integer.parseInt(binDNA.substring(8, 16), 2) / 255f;
			float b = Integer.parseInt(binDNA.substring(16, 24), 2) / 255f;
			//System.out.println("bits: " + binDNA + "; r = " + r + "; g = " + g + "; b = " + b + "; x = " + cell.getX() + "; y = " + cell.getY());
			shapeRenderer.setColor(r, g, b, 1);
			//shapeRenderer.rect(50 + cell.getX(), 50 + cell.getY(), 3, 3);
			shapeRenderer.rect(100 + cell.getX(), 100 + cell.getY(), 3, 2);
		}

		/**boolean s = true;
		int w = 5;
		int h = 5;
		int x = 0;
		int y = 0;
		int n = 10000;

		for(int i = 1; i < n; i++) {


			if(s) {
				shapeRenderer.setColor(1, 1, 1, 1);
			} else {
				shapeRenderer.setColor(0, 0, 0, 1);
			}

			y = (i % 101) * w;
			x = (i / 101) * h;
//			System.out.println("s = " + s + "; x = " + x + "; y = " + y);
//			shapeRenderer.line(200, 200, 64, 64);
			shapeRenderer.rect(x, y, h, w);
//			shapeRenderer.circle(50, 50, 10);
			s = !s;
		}

*/

		batch.end();
		shapeRenderer.end();

		batch.begin();
		font.draw(batch, "Velicina populacije: " + Engine.cells.size(), 100, 70);
		batch.end();
//		shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
//		shapeRenderer.setColor(0, 1, 0, 1);
//		shapeRenderer.rect(x, y, width, height);
//		shapeRenderer.circle(x, y, radius);
//		shapeRenderer.end();

		//Gdx.gl.glClearColor(1, 0, 0, 1);
		//Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		//batch.begin();
		//batch.draw(img, 0, 0);
		//batch.end();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//Engine.cells.clear();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		//img.dispose();
	}
}
