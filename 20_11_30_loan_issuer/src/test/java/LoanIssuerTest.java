import org.junit.Assert;
import org.junit.Test;

public class LoanIssuerTest {

 //there are four types of loan issuers and any client can work with any of them
 LoanIssuer lazyTom = new LoanIssuer("Lazy_but_kind_Tom", true, true);
 LoanIssuer lazyEvil = new LoanIssuer("Lazy_and_mean_Mr.Böse", true, false);
 LoanIssuer hardWorkingAndrey = new LoanIssuer("Hard_working_and_kind_Andrey", false, true);
 LoanIssuer theWorst = new LoanIssuer("Hard_working_and_mean_Mr.Please-take-a-break!", false, false);

 @Test
 public void testToIssue_AgeLessThan18_NotIssuedByAll(){

  LoanConsumer consumer = new LoanConsumer("Too_young_Alex", 17, 25000);


  Assert.assertFalse(lazyTom.toIssue(consumer));
  Assert.assertFalse(lazyEvil.toIssue(consumer));
  Assert.assertFalse(hardWorkingAndrey.toIssue(consumer));
  Assert.assertFalse(theWorst.toIssue(consumer));

  //this definitely shouldn't be here. Still let it be
  logTheResult(consumer);

 }

 @Test
 public void testToIssue_Age18_IssuedByAll(){

  LoanConsumer consumer = new LoanConsumer("Alex_after_18th_Birthday_party", 18, 25000);


  Assert.assertTrue(lazyTom.toIssue(consumer));
  Assert.assertTrue(lazyEvil.toIssue(consumer));
  Assert.assertTrue(hardWorkingAndrey.toIssue(consumer));
  Assert.assertTrue(theWorst.toIssue(consumer));

  logTheResult(consumer);

 }

 @Test
 public void testToIssue_AgeMoreThan18AndSalary20K_IssuedByAll(){

  LoanConsumer consumer = new LoanConsumer("At_last_I_can_have_a_loan_Mark", 28, 20000);


  Assert.assertTrue(lazyTom.toIssue(consumer));
  Assert.assertTrue(lazyEvil.toIssue(consumer));
  Assert.assertTrue(hardWorkingAndrey.toIssue(consumer));
  Assert.assertTrue(theWorst.toIssue(consumer));

  logTheResult(consumer);

 }

 @Test
 public void testToIssue_SalaryLessThan20K_NotIssuedByAll(){

  LoanConsumer consumer = new LoanConsumer("Too_poor_John", 34, 19999);

  Assert.assertFalse(lazyTom.toIssue(consumer));
  Assert.assertFalse(lazyEvil.toIssue(consumer));
  Assert.assertFalse(hardWorkingAndrey.toIssue(consumer));
  Assert.assertFalse(theWorst.toIssue(consumer));

  logTheResult(consumer);

 }

 @Test
 public void testToIssue_SalaryLessThan20KAndTooYoung_NotIssuedByAll(){

  LoanConsumer consumer = new LoanConsumer("Kolya", 5, 64);

  Assert.assertFalse(lazyTom.toIssue(consumer));
  Assert.assertFalse(lazyEvil.toIssue(consumer));
  Assert.assertFalse(hardWorkingAndrey.toIssue(consumer));
  Assert.assertFalse(theWorst.toIssue(consumer));

  logTheResult(consumer);
 }

 @Test
 public void testToIssue_AgeBetween50And70SalaryMoreThan20K_IssuedByAllLazy_IssuedByNotLazyAndKind_NotIssuedByMeanNotLazy(){

  LoanConsumer consumer = new LoanConsumer("But_I_am_not_that_old!_Vasily", 56, 68000);

  Assert.assertTrue(lazyTom.toIssue(consumer));
  Assert.assertTrue(lazyEvil.toIssue(consumer));
  Assert.assertTrue(hardWorkingAndrey.toIssue(consumer));

  Assert.assertFalse(theWorst.toIssue(consumer));

  logTheResult(consumer);

 }

 @Test
 public void testToIssue_AgeBetween18And50SalaryMoreThan20K_IssuedByAll(){

  LoanConsumer consumer = new LoanConsumer("Vasily's_younger_Brother", 29, 68000);

  Assert.assertTrue(lazyTom.toIssue(consumer));
  Assert.assertTrue(lazyEvil.toIssue(consumer));
  Assert.assertTrue(hardWorkingAndrey.toIssue(consumer));
  Assert.assertTrue(theWorst.toIssue(consumer));

  logTheResult(consumer);

 }

 @Test
 public void testToIssue_AgeMoreThan70_IssuedByAllLazy_NotIssuedByAnyNotLazy(){

  LoanConsumer consumer = new LoanConsumer("Too_old_Semyon", 99, 1000000);

  Assert.assertTrue(lazyTom.toIssue(consumer));
  Assert.assertTrue(lazyEvil.toIssue(consumer));

  Assert.assertFalse(hardWorkingAndrey.toIssue(consumer));
  Assert.assertFalse(theWorst.toIssue(consumer));

  logTheResult(consumer);

 }

 @Test
 public void testToIssue_Age70_IssuedByAllLazy_NotIssuedByAnyNotLazy(){

  LoanConsumer consumer = new LoanConsumer("Choose_your_clerk_wisely_Akim", 70, 370000);

  Assert.assertTrue(lazyTom.toIssue(consumer));
  Assert.assertTrue(lazyEvil.toIssue(consumer));

  Assert.assertFalse(hardWorkingAndrey.toIssue(consumer));
  Assert.assertFalse(theWorst.toIssue(consumer));

  logTheResult(consumer);

 }

 @Test
 public void testToIssue_Age69_IssuedByLazyAndKind_NotIssuedByNotKindNotLazy(){

  LoanConsumer consumer = new LoanConsumer("I_can_make_it_with_three_out_of_four_Yuri", 69, 90000);

  Assert.assertTrue(lazyTom.toIssue(consumer));
  Assert.assertTrue(lazyEvil.toIssue(consumer));
  Assert.assertTrue(hardWorkingAndrey.toIssue(consumer));

  Assert.assertFalse(theWorst.toIssue(consumer));

  logTheResult(consumer);

 }

 /**
  * not for test purpose, just to make it visual.
  * prints a decision for certain customer made by each type of loan issuer
  * @param consumer current loanConsumer
     */
 private void logTheResult(LoanConsumer consumer){

  if (lazyTom.toIssue(consumer)) {
    System.out.println("The loan issued to " + consumer.getName() + " by " + lazyTom.getName());
  }
  else {
    System.out.println("The loan NOT issued to " + consumer.getName() + " by " + lazyTom.getName());
  }

  if (lazyEvil.toIssue(consumer)) {
   System.out.println("The loan issued to " + consumer.getName() + " by " + lazyEvil.getName());
  }
  else {
   System.out.println("The loan NOT issued to " + consumer.getName() + " by " + lazyEvil.getName());
  }

  if (hardWorkingAndrey.toIssue(consumer)) {
   System.out.println("The loan issued to " + consumer.getName() + " by " + hardWorkingAndrey.getName());
  }
  else {
   System.out.println("The loan NOT issued to " + consumer.getName() + " by " + hardWorkingAndrey.getName());
  }

  if (theWorst.toIssue(consumer)) {
   System.out.println("The loan issued to " + consumer.getName() + " by " + theWorst.getName());
  }
  else {
   System.out.println("The loan NOT issued to " + consumer.getName() + " by " + theWorst.getName());
  }

 }


}
