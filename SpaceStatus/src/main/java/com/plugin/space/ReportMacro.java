package com.plugin.space;

import java.util.Map;
import java.util.List;
 
import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.atlassian.confluence.pages.PageManager;
import com.atlassian.confluence.pages.AttachmentManager;
import com.atlassian.confluence.pages.Page;
import com.atlassian.confluence.spaces.SpaceManager;
import com.atlassian.confluence.user.AuthenticatedUserThreadLocal;
import com.atlassian.user.User;
import com.opensymphony.util.TextUtils;
  
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import com.atlassian.confluence.json.json.JsonArray;
import com.atlassian.confluence.json.json.JsonObject;
import com.atlassian.confluence.renderer.radeox.macros.MacroUtils;
import com.atlassian.confluence.util.GeneralUtil;
import com.atlassian.confluence.util.velocity.VelocityUtils;
import org.apache.velocity.VelocityContext;
 
public class ReportMacro implements Macro
{
  private final PageManager pageManager;
  private final SpaceManager spaceManager;
  private final AttachmentManager attachmentManager;
 
  public ReportMacro(PageManager pageManager, SpaceManager spaceManager, AttachmentManager attachmentManager)
  {
    this.pageManager = pageManager;
    this.spaceManager = spaceManager; 
    this.attachmentManager = attachmentManager;
  }
  private static final String SPACEKEY = "space";
  private static final String TEMPLATE = "templates/ReportMacro.vm";
 
  @Override
  public BodyType getBodyType()
  {
     return BodyType.NONE;
  }
 
  @Override
  public OutputType getOutputType()
  {
     return OutputType.BLOCK;
  }
  @Override
  public String execute(Map<String, String> params, String body, ConversionContext conversionContext)
                          throws MacroExecutionException
  {
	  String spaceN = getSpaceFromParams(params);
	  VelocityContext contextMap = new VelocityContext(MacroUtils.defaultVelocityContext());
	  contextMap.put(SPACEKEY, spaceN);
	  return VelocityUtils.getRenderedTemplate(TEMPLATE, contextMap);
  }
  private String getSpaceFromParams(Map params) throws MacroExecutionException
  {
	String space = "";
    if (params.size() > 1)
    {
      try
      {
        space = params.get("space").toString();
      }
      catch (Exception e)
      {
        throw new MacroExecutionException("Unable to get Space Key");
      }
    }
    return space;
  }
}
