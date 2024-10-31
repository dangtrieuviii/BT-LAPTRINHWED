package vn.iotstar.configs;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

import jakarta.servlet.Filter;
import jakarta.servlet.ServletException;

public class MySiteMeshFilter extends  ConfigurableSiteMeshFilter {

	@Override
	protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
		// TODO Auto-generated method stub
		builder.addDecoratorPath("/*", "/web.jsp")
				.addDecoratorPath("/admin", "/admin.jsp")
				.addExcludedPath("/v1/api/*");
	}

	@Override
	protected void deployNewFilter(Filter newFilter) throws ServletException {
		// TODO Auto-generated method stub
		super.deployNewFilter(newFilter);
	}
	
	

}