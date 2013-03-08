package com.ebiz.ssi2.web.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class VerificationCodeServlet extends HttpServlet {

	private static final long serialVersionUID = -3981794330055840248L;

	private String codeType;

	public void init(ServletConfig config) throws ServletException {
		this.codeType = config.getInitParameter("codeType");
	}

	public void destroy() {
		this.codeType = null;
		super.destroy();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			java.io.IOException {

		response.addHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Cache-Control", "pre-check=0,post-check=0");
		response.setDateHeader("Expires", 0);

		int type; // type: 0-NUMBER 1-LETTER 2-MULTIPLE
		if (StringUtils.isNotBlank(this.codeType)) {
			type = Integer.valueOf(this.codeType);
		} else {
			type = 0;
		}

		int width = 60, height = 18;
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		Random random = new Random();
		Graphics g = image.getGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, width, height);

		g.setColor(Color.BLUE);
		for (int i = 0; i < 64; i++) {
			g.setColor(new Color(180 + random.nextInt(30), 200 + random.nextInt(30), 200 + random.nextInt(30)));
			int x = random.nextInt(width);
			int y = random.nextInt(height);
			int xl = random.nextInt(12);
			int yl = random.nextInt(12);
			g.drawLine(x, y, x + xl, y + yl);
		}

		String sRand = "";
		Font font = new Font("Verdana", Font.ITALIC, 16);
		g.setFont(font);
		sRand = getValidateCode(4, type);

		for (int i = 0; i < 4; i++) {
			g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
			g.drawString(String.valueOf(sRand.charAt(i)), 13 * i + 6, 16);
		}
		// g.setColor(Color.green);
		// g.drawRect(0, 0, width - 1, height - 1);

		HttpSession session = request.getSession(true);
		session.setAttribute("verificationCode", sRand);

		g.dispose();

		ServletOutputStream sos = response.getOutputStream();
		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(sos);
		encoder.encode(image);
	}

	private String getValidateCode(int size, int type) {
		StringBuffer validate_code = new StringBuffer();
		for (int i = 0; i < size; i++) {
			validate_code.append(getOneChar(type));
		}

		return validate_code.toString();
	}

	private String getOneChar(int type) {
		Random random = new Random();
		String result = null;
		switch (type) {
		case 0:
			result = String.valueOf(random.nextInt(10));
			break;
		case 1:
			result = String.valueOf((char) (random.nextInt(26) + 65));
			break;
		case 2:
			if (random.nextBoolean()) {
				result = String.valueOf(random.nextInt(10));
			} else {
				result = String.valueOf((char) (random.nextInt(26) + 65));
			}
			break;
		default:
			result = null;

			break;
		}
		if (result == null)
			throw new NullPointerException("GET VerificationCode ERROR!");
		return result;
	}

	public String getCodeType() {
		return codeType;
	}

	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

}
