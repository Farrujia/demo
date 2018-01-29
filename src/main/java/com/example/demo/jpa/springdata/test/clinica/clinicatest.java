/*package com.example.demo.jpa.springdata.test.clinica;

import org.junit.Test;

import junit.framework.Assert;

public class clinicatest {

	
		private calcService service = new CalcServiceImpl();
		
		@Test
		public void suma() {
			final Integer suma = service.suma(2,4);
			Assert.assertEquals(suma, Integer.valueOf(6);
		}
		
		
		public void mult() {
			//Mockito.when(service.suma(8,8)).thenReturn(16)
			finnal Integer mult = service.mult(2,8);
			Assert.assertEquals(mult, Integer.valueOf(16));
		}
}













	@RunWith(MockitoJUnitRunner.class)
	public class TestUserService
	{
	@InjectMocks
	private UserService service = new UserServiceImpl();
	
	@Mock
	private UserDao da;

	@Test
	public void testFindByIdBase()
	{
		final User user = new User;
		final String name = "David";
		user.setName();
		Mockito.when(dao.findone(8).thenReturn(user);
		
		final User res = service.findById(8)
		AssertNotNull(res);
		Assert.assertEquals(name,res.getName())
	}

	@Test(expected = NotFoundException.class)
	public void testFindByIdNotFound(){
	service.findById(999);
	




*/
