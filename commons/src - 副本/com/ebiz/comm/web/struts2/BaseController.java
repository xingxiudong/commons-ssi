package com.ebiz.comm.web.struts2;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.ebiz.comm.service.Facade;
import com.ebiz.ssi2.web.struts2.BaseSsi2Controller;

@Controller
public class BaseController extends BaseSsi2Controller{

	private static final long serialVersionUID = -3178022323267809698L;

	@Resource
	private Facade facade;

	protected Facade getFacade() {
		return this.facade;
	}

}
