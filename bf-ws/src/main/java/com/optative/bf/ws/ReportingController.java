package com.optative.bf.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.optative.bf.dao.BlackFridayDao;
import com.optative.bf.vo.DealList;

/**
 * Restful services for Monitoring service.
 * 
 * @author aart0328
 * 
 */
@Controller
public class ReportingController {

	@Autowired
	private BlackFridayDao daoImpl;

	private static final Logger log = LoggerFactory
			.getLogger(ReportingController.class);

	@RequestMapping(value = "/deal", method = RequestMethod.POST)
	public @ResponseBody void addDeal(@RequestBody DealList deal) {

		log.debug("writing node metrics to data base");
		daoImpl.addDeal(deal);
	}

	@RequestMapping(value = "/deals/store/{storeName}", method = RequestMethod.GET)
	public @ResponseBody DealList getDealsByStore(@PathVariable String storeName) {

		return daoImpl.getDealsByStore(storeName);
	}

	@RequestMapping(value = "/deals/store/{storeName}/category/{categoryName}", method = RequestMethod.GET)
	public DealList getDealsByStoreAndCategory(@PathVariable String storeName,
			@PathVariable String categoryName) {

		return daoImpl.getDealsByStoreAndCategory(storeName, categoryName);

	}

	@RequestMapping(value = "/deals/store/{storeName}/category/{categoryName}/item/{itemName}", method = RequestMethod.GET)
	public DealList getDealsByStoreAndCategoryAndItem(
			@PathVariable String storeName, @PathVariable String categoryName,
			@PathVariable String itemName) {

		return daoImpl.getDealsByStoreAndCategoryAndItem(storeName,
				categoryName, itemName);

	}

	@RequestMapping(value = "/deals/category/{categoryName}", method = RequestMethod.GET)
	public @ResponseBody DealList getDealsByCategory(
			@PathVariable String categoryName) {

		return daoImpl.getDealsByCategory(categoryName);
	}

	@RequestMapping(value = "/deals/item/{itemName}", method = RequestMethod.GET)
	public @ResponseBody DealList getDealsByItem(@PathVariable String itemName) {

		return daoImpl.getDealsByItem(itemName);
	}

	@RequestMapping(value = "/deals/category/{categoryName}/item/{itemName}", method = RequestMethod.GET)
	public @ResponseBody DealList getDealsByCategoryAndItem(
			@PathVariable String categoryName, @PathVariable String itemName) {

		return daoImpl.getDealsByCategoryAndItem(categoryName, itemName);
	}

	/**
	 * Handling of client errors.
	 * 
	 * Returns HTTP status code 400 (bad request).
	 * 
	 * @param ex
	 *            The client error.
	 * @return The error message.
	 */
	// These exceptions denote client errors.
	@ExceptionHandler({ IllegalArgumentException.class,
			MissingServletRequestParameterException.class,
			TypeMismatchException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public @ResponseBody String handleClientErrors(Exception ex) {
		return ex.getMessage();
	}

	@ExceptionHandler(IllegalStateException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public @ResponseBody String notFound(Exception ex) {
		return ex.getMessage();
	}

	@ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
	@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE, reason = "UnSupported Media Type")
	public @ResponseBody String notAcceptable(Exception ex) {
		return ex.getMessage();
	}

	@ExceptionHandler(UnsupportedOperationException.class)
	@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED, reason = "Not Implemented")
	public @ResponseBody String notSupported(Exception ex) {
		return ex.getMessage();
	}

	@ExceptionHandler(UnsupportedOperationException.class)
	@ResponseStatus(value = HttpStatus.NOT_IMPLEMENTED, reason = "Not Implemented")
	public void notSupported() {
	}

	/**
	 * Handling of server errors.
	 * 
	 * Returns HTTP status code 500 (internal server error).
	 * 
	 * @param ex
	 *            The server error.
	 * @return The error message.
	 */
	// All other exceptions are server errors.
	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public @ResponseBody String handleServerErrors(Exception ex) {
		return ex.getMessage();
	}

}
