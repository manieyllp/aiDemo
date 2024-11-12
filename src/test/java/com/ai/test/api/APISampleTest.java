//package com.ai.test.api;
//
//	import java.lang.invoke.MethodHandles;
//
//	import org.skyscreamer.jsonassert.JSONCompareMode;
//	import org.slf4j.Logger;
//	import org.slf4j.LoggerFactory;
//	import org.testng.annotations.Test;
//
//	import com.zebrunner.carina.api.apitools.validation.JsonCompareKeywords;
//	import com.zebrunner.carina.core.IAbstractTest;
//	import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
//	import com.zebrunner.carina.core.registrar.tag.TestPriority;
//	import com.zebrunner.carina.core.foundation.utils.tag.TestPriority;
//	import com.zebrunner.carina.demo.api.DeleteUserMethod;
//	import com.zebrunner.carina.demo.api.GetUserMethods;
//	import com.zebrunner.carina.demo.api.PostUserMethod;
//
//	/**
//	 * This sample shows how create REST API tests.
//	 *
//	 * @author qpsdemo
//	 */
//	public class APISampleTest implements IAbstractTest {
//
//	    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
//
//	    @Test()
//	    @MethodOwner(owner = "qpsdemo")
//	    public void testCreateUser() {
//	        LOGGER.info("test");
//	        setCases("4555,54545");
//	        PostUserMethod api = new PostUserMethod();
//	        api.expectResponseStatus(HttpResponseStatusType.CREATED_201);
//	        api.callAPI();
//	        api.validateResponse();
//	    }
//}
