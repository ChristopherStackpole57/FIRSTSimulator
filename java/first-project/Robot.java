import api.eventloop.opmode.LinearOpMode;
import api.hardware.DcMotor;

public class Robot extends LinearOpMode {
  private DcMotor leftDrive = null;
  private DcMotor rightDrive = null;

  public Robot() {
    System.out.println("Created robot.");
  }

  @Override
  public void runOpMode() {
    leftDrive = new DcMotor();
    rightDrive = new DcMotor();

    leftDrive.setDirection(DcMotor.Direction.REVERSE);
    rightDrive.setDirection(DcMotor.Direction.FORWARD);
  }
}