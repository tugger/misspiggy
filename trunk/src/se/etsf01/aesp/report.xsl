<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html"/>
    
    <xsl:template match="estimation">
        <html>
            <head>
                <title>Estimation Report</title>
                <style type="text/css">
                    body {
                        padding:0px;
                        margin:0pt;
                        font-family:Tahoma,Serif;
                        font-size:12pt;
                    }
                    
                    h2 {
                        font-size:22pt;
                        margin: 5pt;
                        font-weight:bold;
                        margin-bottom:10pt;
                        border-bottom: 1px solid #000000;
                    }
                    
                    h3 {
                        font-size:16pt;
                        font-weight:bold;
                        margin: 5pt;
                        margin-bottom:10pt;
                    }
                    
                    p {
                        font-size:12pt;
                        margin:5pt;
                    }
                    
                    table
                    {
                        border-collapse:collapse;
                        margin:5pt;
                    }
                    table, td, th
                    {
                        border:1px solid black;
                        padding:3pt;
                    }
                    
                    th {
                        font-weight:bold;
                    }
                </style>
            </head>
            <body>
                <h2>Estimation Result</h2>
                <p><xsl:value-of select="project/effort/ph"/> ph = <xsl:value-of select="project/effort/pd"/> pd = <xsl:value-of select="project/effort/pm"/> pm = <xsl:value-of select="project/effort/py"/> py</p>
                <h3>Notes:</h3>
                <p><xsl:value-of select="project/effort/notes"/></p>
                <h2>Estimation Basis:</h2>
                <table id="project">
                    <tr>
                        <th>Type</th>
                        <th>Value</th>
                    </tr>
                    <xsl:for-each select="project/characteristic">
                        <tr>
                            <td><xsl:value-of select="@name" /></td>
                            <td><xsl:value-of select="@value" /></td>
                        </tr>
                    </xsl:for-each>
                    <tr>
                        <td>Size</td>
                        <td><xsl:value-of select="project/size"/> kLOC</td>
                    </tr>
                </table>
                <h2>Similar projects</h2>
                <table id="similiar">
                    <tr>
                        <th>#</th>
                        <th>Similarity</th>
                        <th>Size (kLOC)</th>
                        <th>Actual Effort</th>
                        <xsl:for-each select="similar/characteristics/item">
                            <th><xsl:value-of select="@name" /></th>
                        </xsl:for-each>
                    </tr>
                    <xsl:for-each select="similar/project">
                        <tr>
                        <td><xsl:value-of select="@number" /></td>
                        <td><xsl:value-of select="@similarity" />%</td>
                        <td><xsl:value-of select="@size" /></td>
                        <td><xsl:value-of select="@effort" /> pm</td>
                        <xsl:for-each select="characteristic">
                            <td><xsl:value-of select="@value" /></td>
                        </xsl:for-each>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>
