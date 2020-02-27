package resources;

public class AnimationHandler {
  private Sprite sprite;
  private int frame = 0;
  private int animationTime = 0;
  private double animationSpeed = 0.25D;
  private boolean enabled = true;
  
  public AnimationHandler(Sprite sprite) { this.sprite = sprite; }
  
  public void animate(int x, int y, boolean flipHorizontal, boolean flipVertical) {
    sprite.setFrame(frame);
    sprite.draw(x, y, flipHorizontal, flipVertical);
    if (animationTime >= Math.round(1.0D / animationSpeed)) {
      frame += 1;
      animationTime = 0;
    }
    if (frame > sprite.getFrameCount() - 1) {
      frame = 0;
    }
    animationTime += 1;
  }
  
  public void setSprite(Sprite sprite) { this.sprite = sprite; }
  
  public double getAnimationSpeed() {
    return animationSpeed;
  }
  
  public void setAnimationSpeed(double animationSpeed) { this.animationSpeed = animationSpeed; }
  
  public void setFrame(int frame) {
    this.frame = frame;
  }
}
