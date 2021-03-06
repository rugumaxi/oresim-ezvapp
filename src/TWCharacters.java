
public class TWCharacters {

	public int charIndex = -1;
	
    /**
     * LN^¼
     */
    public static final String[] _name = {
    	"VA",
    	"{X",
    	"}LV~",
    	"Vx",
    	"~",
    	"eB`G",
    	"CXs",
    	"igC",
    	"WVA",
    	"NG",
    	"WG",
    	"CTbN",
    	"AiCX"
    };


    /**
     * ^¼
     */
    public static final String[][] _styleName = {
    	/* VA   */
    	{ "¨¡", "aè", "Ë«" },
    	/* {X     */
    	{ "¨¡", "aè", "m" },
    	/* }LV~ */
    	{ "¨¡", "aè", "m" },
    	/* Vx   */
    	{ "Ë«", "¨¡", "aè" },
    	/* ~       */
    	{ "aè", "¨¡", "Ë«" },
    	/* eB`G */
    	{ "U", "â", "í¬" },
    	/* CXs   */
    	{ "Ë«", "¨¡", "aè" },
    	/* igC */
    	{ "Ë«", "¨¡", "aè" },
    	/* WVA */
    	{ "­»", "Ï»", "úo" },
    	/* NG */
    	{ "p", "p", "p" },
    	/* WG */
    	{ "¨", "@", "â" },
    	/* CTbN */
    	{ "CT^", "CU^", "CV^" },
    	/* AiCX */
    	{ "AT^", "AU^", "AV^" }
    };

    /**
     * ^
     */
    private int[] _style = { 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    /**
     * úXe[^X
     */
    public static final int[][][] _defaultStatus = {
    	
        /* VA   */
    	{    /* ¨¡ */ { 4, 3, 1, 2, 1, 2, 2, 220, 50, 1000, 1100 },
    	     /*    aè  */ { 3, 4, 1, 3, 1, 2, 1, 240, 55,  900, 1150 },
    	     /*    Ë«  */ { 4, 3, 1, 1, 1, 2, 3, 200, 55, 1100, 1050 }
    	},
    	/* {X     */
    	{
    	    /* ¨¡ */ { 3, 4, 1, 3, 2, 1, 1, 200, 50, 950, 1100 },
    	    /*    aè  */ { 2, 5, 1, 3, 2, 1, 1, 220, 55, 900, 1150 },
    	    /*   m */ { 2, 4, 2, 2, 2, 2, 1, 185, 65, 850, 999 }
        },
    	/* }LV~ */
        {
            /* ¨¡ */ { 4, 4, 1, 2, 1, 2, 1, 190, 50, 950, 1050 },
            /*    aè  */ { 3, 5, 1, 2, 1, 2, 1, 210, 55, 900, 1100 },
            /*   m */ { 2, 4, 2, 2, 2, 2, 1, 175, 65, 850, 999 }
        },
    	/* Vx   */
        {
            /*    Ë«  */ { 5, 2, 1, 3, 1, 2, 1, 220, 45, 1300, 1150 },
            /* ¨¡ */ { 4, 4, 1, 3, 1, 1, 1, 240, 40, 1200, 1200 },
            /*    aè  */ { 2, 5, 1, 4, 1, 1, 1, 260, 40, 1100, 1250 }
        },
    	/* ~       */
        {
            /*    aè  */ { 2, 4, 1, 1, 2, 3, 2, 210, 35, 1000,  950 },
            /* ¨¡ */ { 4, 4, 1, 1, 1, 2, 2, 190, 40, 1100,  900 },
            /*    Ë«  */ { 4, 2, 1, 1, 2, 3, 2, 170, 35, 1200,  850 }
        },
    	/* eB`G */
        {
            /* @U@ */ { 1, 2, 4, 1, 3, 2, 2, 160, 80, 800, 750 },
            /*   â   */ { 1, 2, 2, 2, 3, 2, 3, 170, 90, 900, 800 },
            /*   í¬   */ { 1, 3, 1, 3, 2, 2, 3, 185, 70, 1100, 850 }
        },
    	/* CXs   */
        {
            /*    Ë«  */ { 4, 2, 1, 2, 1, 3, 2, 190, 45, 1200,  900 },
            /* ¨¡ */ { 4, 3, 1, 2, 1, 2, 2, 210, 50, 1100,  950 },
            /*    aè  */ { 2, 4, 1, 2, 1, 3, 2, 200, 55, 1000, 1000 }
        },
    	/* igC */
        {
            /*    Ë«  */ { 4, 2, 1, 1, 1, 3, 3, 185, 40, 1400,  850 },
            /* ¨¡ */ { 4, 3, 1, 1, 1, 3, 2, 205, 45, 1300,  900 },
            /*    aè  */ { 2, 4, 1, 1, 1, 4, 2, 225, 50, 1200,  950 }
        },
        /* WVA */
        {
            /* ­» */ { 4, 2, 3, 1, 3, 1, 1, 220, 60, 930, 1075 },
            /* Ï» */ { 3, 1, 3, 2, 3, 2, 1, 220, 70, 920, 1050 },
            /* úo */ { 3, 1, 4, 1, 3, 2, 1, 220, 75, 910, 1050 }
        },
        /* NG */
        {
            /* p */ { 1, 2, 4, 1, 3, 2, 2, 180, 80, 800, 750 },
            /* p */ { 1, 2, 3, 2, 4, 2, 2, 170, 90, 900, 800 },
            /* p */ { 1, 2, 3, 1, 3, 3, 2, 180, 70,1000, 850 }
        },
        /* WG */
        {
            /* ¨ */ { 4, 2, 2, 1, 3, 2, 1, 220, 60, 930, 1125 },
            /* @ */ { 2, 1, 4, 2, 3, 2, 1, 210, 70, 920, 1100 },
            /* â */ { 3, 1, 3, 1, 3, 2, 2, 200, 80, 910, 1115 }
        },
        /* CTbN */
        {
            /* CT^ */ { 4, 2, 3, 1, 3, 1, 1, 220, 60, 930, 1075 },
            /* CU^ */ { 3, 1, 3, 2, 3, 2, 1, 220, 70, 920, 1050 },
            /* CV^ */ { 3, 1, 4, 1, 3, 2, 1, 220, 75, 910, 1050 }
        },
        /* AiCX */
        {
            /* AT^ */ { 4, 2, 3, 1, 3, 1, 1, 220, 60, 930, 1075 },
            /* AU^ */ { 3, 1, 3, 2, 3, 2, 1, 220, 70, 920, 1050 },
            /* AV^ */ { 3, 1, 4, 1, 3, 2, 1, 220, 75, 910, 1050 }
        },
    };
    
    /**
     * úKv|Cg
     */
    public static final int [][][] _defaultNeedPoints = {

    	/* VA   */
    	{   /* ¨¡ */ { 1, 1, 3, 2, 3, 2, 2 },
    	    /*    aè  */ { 2, 1, 3, 1, 3, 2, 2 },
    	    /*    Ë«  */ { 1, 2, 3, 2, 3, 2, 1 }
    	},
    	/* {X     */
    	{
    	    /* ¨¡ */ { 2, 1, 3, 1, 3, 2, 2 },
    	    /*    aè  */ { 3, 1, 3, 1, 2, 2, 2 },
    	    /*   m */ { 3, 1, 2, 2, 3, 1, 2 }
    	},
    	/* }LV~ */
    	{
    	    /* ¨¡ */ { 1, 1, 3, 2, 3, 2, 2 },
    	    /*    aè  */ { 2, 1, 3, 2, 3, 1, 2 },
    	    /*   m */ { 3, 1, 2, 3, 2, 1, 2 }
    	},
    	/* Vx   */
    	{
    	    /*    Ë«  */ { 1, 2, 3, 1, 3, 2, 2 },
    	    /* ¨¡ */ { 1, 1, 3, 2, 3, 2, 2 },
    	    /*    aè  */ { 2, 1, 3, 1, 3, 2, 2 }
    	},
    	/* ~       */
    	{
    	    /*    aè  */ { 2, 1, 3, 2, 3, 1, 2 },
    	    /* ¨¡ */ { 1, 1, 3, 2, 3, 2, 2 },
    	    /*    Ë«  */ { 1, 2, 3, 2, 3, 1, 2 }
    	},
    	/* eB`G */
    	{
    	    /* @U@ */ { 3, 2, 2, 3, 1, 1, 2 },
    	    /*   â   */ { 3, 3, 2, 2, 1, 2, 1 },
    	    /*   í¬   */ { 2, 1, 3, 3, 2, 2, 1 }
    	},
    	/* CXs   */
    	{
    	    /*    Ë«  */ { 1, 2, 3, 2, 3, 1, 2 },
    	    /* ¨¡ */ { 1, 1, 3, 2, 3, 2, 2 },
    	    /*    aè  */ { 2, 1, 3, 2, 3, 1, 2 },
    	},
    	/* igC */
    	{
    	    /*    Ë«  */ { 1, 2, 3, 2, 3, 2, 1 },
    	    /* ¨¡ */ { 1, 1, 3, 2, 3, 2, 2 },
    	    /*    aè  */ { 2, 1, 3, 2, 3, 1, 2 }
    	},
    	/* WVA */
    	{
    	    /* ­» */ { 1, 2, 3, 1, 3, 2, 2 },
    	    /* Ï» */ { 2, 3, 2, 2, 1, 2, 2 },
    	    /* úo */ { 2, 3, 2, 3, 1, 1, 2 }
    	},
    	/* NG */
    	{
    	    /* p */ { 3, 2, 2, 3, 1, 1, 2 },
    	    /* p */ { 3, 2, 2, 3, 1, 1, 2 },
    	    /* p */ { 3, 2, 2, 3, 1, 1, 2 }
    	},
    	/* WG */
    	{
    	    /* ¨ */ { 1, 2, 3, 1, 3, 2, 2 },
    	    /* @ */ { 2, 3, 2, 2, 1, 2, 2 },
    	    /* â */ { 2, 3, 2, 3, 1, 1, 2 }
    	},
    	/* CTbN */
    	{
    	    /* CT^ */ { 1, 2, 3, 1, 3, 2, 2 },
    	    /* CU^ */ { 2, 3, 2, 2, 1, 2, 2 },
    	    /* CV^ */ { 2, 3, 2, 3, 1, 1, 2 }
    	},
    	/* AiCX */
    	{
    	    /* AT^ */ { 1, 2, 3, 1, 3, 2, 2 },
    	    /* AU^ */ { 2, 3, 2, 2, 1, 2, 2 },
    	    /* AV^ */ { 2, 3, 2, 3, 1, 1, 2 }
    	}
    };

    /**
     * úXien
     */
    public static final int [][][] _defaultXien = {

        /* VA   */
    	{    /* ¨¡ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
             /*    aè  */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
             /*    Ë«  */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    	},
    	/* {X     */
    	{
    	    /* ¨¡ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /*    aè  */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /*   m */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    	},
    	/* }LV~ */
    	{
    	    /* ¨¡ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /*    aè  */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /*   m */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    	},
    	/* Vx   */
    	{
    	    /*    Ë«  */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /* ¨¡ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /*    aè  */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    	},
    	/* ~       */
    	{
    	    /*    aè  */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /* ¨¡ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /*    Ë«  */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    	},
    	/* eB`G */
    	{
    	    /* @U@ */ { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /*   â   */ { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /*   í¬   */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    	},
    	/* CXs   */
    	{
    	    /*    Ë«  */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /* ¨¡ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /*    aè  */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    	},
    	/* igC */
    	{
    	    /*    Ë«  */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /* ¨¡ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /*    aè  */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    	},
    	/* WVA */
    	{
    	    /* ­» */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /* Ï» */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /* úo */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    	},
    	/* NG */
    	{
    	    /* p */ { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /* p */ { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /* p */ { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }
    	},
    	/* WG */
    	{
    	    /* ¨ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
    	    /* @ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },
    	    /* â */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 }
    	},
    	/* CTbN */
    	{
    	    /* CT^ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
    	    /* CU^ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
    	    /* CV^ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }
    	},
    	/* AiCX */
    	{
    	    /* AT^ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
    	    /* AU^ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
    	    /* AV^ */ { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 }
    	},
    };
    
    /**
     * LVÊÅåXien
     * 
     * ³®«
     * În
     * Xn
     * ¾n
     * ånn
     * dn
     * @
     * @
     * ¤Ên
     * n
     * n
     * n
     * Ún
     * Ån
     * pn
     * pn
     * pn
     * ¨n
     * @n
     * ân
     * CTn
     * CUn
     * CVn
     * ATn
     * AUn
     * AVn
     */
    public static final int [][][] _maxXien = {
        /* VA   */
        {
        /* ³®« */   { 0 },
        /* În */   {  99
                       },
        /* Xn */   { 0 },
        /* ¾n */   { 99
                       },
        /* ånn */   { 0 },
        /* dn */   { 99
                       },
        /* @ */   { 0 },
        /* @ */   { 0 },
        /* ¤Ên */   { 99
                       },
        /*  n  */   { 99
                       },
        /*  n  */   { 99
                       },
        /*  n  */   { 0 },
        /*  Ún  */   { 0 },
        /* Ån */   { 0 },
        /* ­»n */   { 0 },
        /* Ï»n */   { 0 },
        /* úon */   { 0 },
        /* pn */   { 0 },
        /* pn */   { 0 },
        /* pn */   { 0 },
        /* ¨n */   { 0 },
        /* @n */   { 0 },
        /* ân */   { 0 },
        /* CTn */   { 0 },
        /* CUn */   { 0 },
        /* CVn */   { 0 },
        /* ATn */   { 0 },
        /* AUn */   { 0 },
        /* AVn */   { 0 }
        },
    	/* {X     */
        {
            /* ³®« */   { 0 },
            /* În */   { 0 },
            /* Xn */   { 99
                           },
            /* ¾n */   { 0 },
            /* ånn */   { 99
                           },
            /* dn */   { 0 },
            /* @ */   { 0 },
            /* @ */   { 99
                           },
            /* ¤Ên */   { 99
                           },
            /*  n  */   { 99
                           },
            /*  n  */   { 99
                           },
            /*  n  */   { 0 },
            /*  Ún  */   { 0 },
            /* Ån */   { 0 },
            /* ­»n */   { 0 },
            /* Ï»n */   { 0 },
            /* úon */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* ¨n */   { 0 },
            /* @n */   { 0 },
            /* ân */   { 0 },
            /* CTn */   { 0 },
            /* CUn */   { 0 },
            /* CVn */   { 0 },
            /* ATn */   { 0 },
            /* AUn */   { 0 },
            /* AVn */   { 0 }

        },
    	/* }LV~ */
        {
            /* ³®« */   { 0 },
            /* În */   { 0 },
            /* Xn */   { 0 },
            /* ¾n */   { 
                             99
                           },
            /* ånn */   { 0 },
            /* dn */   { 99
                           },
            /* @ */   { 0 },
            /* @ */   { 99
                           },
            /* ¤Ên */   { 99 },
            /*  n  */   { 99 },
            /*  n  */   { 99 },
            /*  n  */   { 0 },
            /*  Ún  */   { 0 },
            /* Ån */   { 0 },
            /* ­»n */   { 0 },
            /* Ï»n */   { 0 },
            /* úon */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* ¨n */   { 0 },
            /* @n */   { 0 },
            /* ân */   { 0 },
            /* CTn */   { 0 },
            /* CUn */   { 0 },
            /* CVn */   { 0 },
            /* ATn */   { 0 },
            /* AUn */   { 0 },
            /* AVn */   { 0 }

        },
    	/* Vx   */
        {
            /* ³®« */   { 0 },
            /* În */   { 0 },
            /* Xn */   { 0 },
            /* ¾n */   { 0 },
            /* ånn */   { 0 },
            /* dn */   { 0 },
            /* @ */   { 0 },
            /* @ */   { 0 },
            /* ¤Ên */   { 99 },
            /*  n  */   { 0 },
            /*  n  */   { 0 },
            /*  n  */   { 99 },
            /*  Ún  */   { 0 },
            /* Ån */   { 99 },
            /* ­»n */   { 0 },
            /* Ï»n */   { 0 },
            /* úon */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* ¨n */   { 0 },
            /* @n */   { 0 },
            /* ân */   { 0 },
            /* CTn */   { 0 },
            /* CUn */   { 0 },
            /* CVn */   { 0 },
            /* ATn */   { 0 },
            /* AUn */   { 0 },
            /* AVn */   { 0 }

        },
    	/* ~       */
        {
            /* ³®« */   { 0 },
            /* În */   { 0 },
            /* Xn */   { 0 },
            /* ¾n */   { 0 },
            /* ånn */   { 0 },
            /* dn */   { 0 },
            /* @ */   { 0 },
            /* @ */   { 0 },
            /* ¤Ên */   { 99 },
            /*  n  */   { 0 },
            /*  n  */   { 0 },
            /*  n  */   { 0 },
            /*  Ún  */   { 99 },
            /* Ån */   { 99 },
            /* ­»n */   { 0 },
            /* Ï»n */   { 0 },
            /* úon */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* ¨n */   { 0 },
            /* @n */   { 0 },
            /* ân */   { 0 },
            /* CTn */   { 0 },
            /* CUn */   { 0 },
            /* CVn */   { 0 },
            /* ATn */   { 0 },
            /* AUn */   { 0 },
            /* AVn */   { 0 }
        },
    	/* eB`G */
        {
            /* ³®« */   { 99 },
            /* În */   { 99 },
            /* Xn */   { 99 },
            /* ¾n */   { 0 },
            /* ånn */   { 0 },
            /* dn */   { 99 },
            /* @ */   { 99 },
            /* @ */   { 0 },
            /* ¤Ên */   { 99 },
            /*  n  */   { 0 },
            /*  n  */   { 0 },
            /*  n  */   { 0 },
            /*  Ún  */   { 0 },
            /* Ån */   { 99 },
            /* ­»n */   { 0 },
            /* Ï»n */   { 0 },
            /* úon */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* ¨n */   { 0 },
            /* @n */   { 0 },
            /* ân */   { 0 },
            /* CTn */   { 0 },
            /* CUn */   { 0 },
            /* CVn */   { 0 },
            /* ATn */   { 0 },
            /* AUn */   { 0 },
            /* AVn */   { 0 }

        },
    	/* CXs   */
        {
            /* ³®« */   { 0 },
            /* În */   { 99 },
            /* Xn */   { 0 },
            /* ¾n */   { 0 },
            /* ånn */   { 99 },
            /* dn */   { 0 },
            /* @ */   { 99 },
            /* @ */   { 0 },
            /* ¤Ên */   { 99 },
            /*  n  */   { 99 },
            /*  n  */   { 99 },
            /*  n  */   { 0 },
            /*  Ún  */   { 0 },
            /* Ån */   { 0 },
            /* ­»n */   { 0 },
            /* Ï»n */   { 0 },
            /* úon */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* ¨n */   { 0 },
            /* @n */   { 0 },
            /* ân */   { 0 },
            /* CTn */   { 0 },
            /* CUn */   { 0 },
            /* CVn */   { 0 },
            /* ATn */   { 0 },
            /* AUn */   { 0 },
            /* AVn */   { 0 }

        },
    	/* igC */
        {
            /* ³®« */   { 0 },
            /* În */   { 0 },
            /* Xn */   { 99 },
            /* ¾n */   { 0 },
            /* ånn */   { 0 },
            /* dn */   { 99 },
            /* @ */   { 0 },
            /* @ */   { 99 },
            /* ¤Ên */   { 99 },
            /*  n  */   { 99 },
            /*  n  */   { 99 },
            /*  n  */   { 0 },
            /*  Ún  */   { 0 },
            /* Ån */   { 99 },
            /* ­»n */   { 0 },
            /* Ï»n */   { 0 },
            /* úon */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* pn */   { 0 },
            /* ¨n */   { 0 },
            /* @n */   { 0 },
            /* ân */   { 0 },
            /* CTn */   { 0 },
            /* CUn */   { 0 },
            /* CVn */   { 0 },
            /* ATn */   { 0 },
            /* AUn */   { 0 },
            /* AVn */   { 0 }

        },
        /* WVA */
        {
        /* ³®« */   { 0 },
        /* În */   { 0 },
        /* Xn */   { 0 },
        /* ¾n */   { 0 },
        /* ånn */   { 0 },
        /* dn */   { 0 },
        /* @ */   { 0 },
        /* @ */   { 0 },
        /* ¤Ên */   { 99 },
        /*  n  */   { 0 },
        /*  n  */   { 0 },
        /*  n  */   { 0 },
        /*  Ún  */   { 0 },
        /* Ån */   { 0 },
        /* ­»n */   { 99 },
        /* Ï»n */   { 99 },
        /* úon */   { 99 },
        /* pn */   { 0 },
        /* pn */   { 0 },
        /* pn */   { 0 },
        /* ¨n */   { 0 },
        /* @n */   { 0 },
        /* ân */   { 0 },
        /* CTn */   { 0 },
        /* CUn */   { 0 },
        /* CVn */   { 0 },
        /* ATn */   { 0 },
        /* AUn */   { 0 },
        /* AVn */   { 0 }
        },
        /* NG */
        {
        /* ³®« */   { 99 },
        /* În */   { 0 },
        /* Xn */   { 0 },
        /* ¾n */   { 99 },
        /* ånn */   { 99 },
        /* dn */   { 0 },
        /* @ */   { 0 },
        /* @ */   { 0 },
        /* ¤Ên */   { 99 },
        /*  n  */   { 0 },
        /*  n  */   { 0 },
        /*  n  */   { 0 },
        /*  Ún  */   { 0 },
        /* Ån */   { 0 },
        /* ­»n */   { 0 },
        /* Ï»n */   { 0 },
        /* úon */   { 0 },
        /* pn */   { 99 },
        /* pn */   { 99 },
        /* pn */   { 99 },
        /* ¨n */   { 0 },
        /* @n */   { 0 },
        /* ân */   { 0 },
        /* CTn */   { 0 },
        /* CUn */   { 0 },
        /* CVn */   { 0 },
        /* ATn */   { 0 },
        /* AUn */   { 0 },
        /* AVn */   { 0 }
    },
    /* WG */
    {
        /* ³®« */   { 0 },
        /* În */   { 0 },
        /* Xn */   { 0 },
        /* ¾n */   { 0 },
        /* ånn */   { 0 },
        /* dn */   { 0 },
        /* @ */   { 0 },
        /* @ */   { 0 },
        /* ¤Ên */   { 99 },
        /*  n  */   { 0 },
        /*  n  */   { 0 },
        /*  n  */   { 0 },
        /*  Ún  */   { 0 },
        /* Ån */   { 0 },
        /* ­»n */   { 0 },
        /* Ï»n */   { 0 },
        /* úon */   { 0 },
        /* pn */   { 0 },
        /* pn */   { 0 },
        /* pn */   { 0 },
        /* ¨n */   {  2, 2, 2, 3, 3, 4, 5, 5, 6, 7,   8, 9,10,11,11,12,13,13,14,14,
                         16,17,18,20,20,21,22,24,25,25,  26,27,28,29,30,31,32,33,33,33,
                         34,36,37,38,38,39,40,41,43,44,  45,46,47,48,48,49,50,51,52,52,
                         53,54,55,56,56,57,58,59,60,60,  61,62,63,64,64,65,66,67,68,69,
                         70,71,72,73,73,74,75,76,77,77,  78,79,80,81,81,82,83,84,85,85,
                         85,86,87,88,88,88,89,90,91,92,  92,93,94,95,95,95,96,97,98,98,
                         98,99 },
        /* @n */   {  2, 4, 4, 5, 5, 6, 9, 9,10,11,  12,15,16,18,19,20,21,21,23,23,
                         25,27,27,29,29,30,32,33,35,36,  37,40,40,41,42,43,45,46,47,47,
                         48,52,52,53,54,55,57,57,59,60,  61,63,63,64,64,65,67,67,68,69,
                         70,72,73,74,74,75,77,77,78,78,  79,81,81,82,83,84,86,86,87,88,
                         89,91,91,92,92,93,95,96,97,98,  99 },
        /* ân */   {  0, 0, 0, 0, 0, 0, 0, 0, 0, 2,   2, 2, 2, 2, 2, 2, 2, 2, 2, 3,
                          3, 3, 3, 3, 3, 3, 3, 3, 3, 5,   5, 5, 5, 5, 5, 5, 5, 5, 5, 6,
                          6, 6, 6, 6, 6, 6, 6, 6, 6,10,  10,10,10,10,10,10,10,10,10,11,
                         11,11,11,11,11,11,11,11,11,14,  14,14,14,14,14,14,14,14,14,15,
                         15,15,15,15,15,15,15,15,15,19,  19,19,19,19,19,19,19,19,19,20,
                         20,20,20,20,20,20,20,20,20,23,  23,23,23,23,23,23,23,23,23,24,
                         24,24,24,24,24,24,24,24,24,28,  28,28,28,28,28,28,28,28,28,29,
                         29,29,29,29,29,29,29,29,29,31,  31,31,31,31,31,31,31,31,31,32,
                         32,32,32,32,32,32,32,32,32,35,  35,35,35,35,35,35,35,35,35,36,
                         36,36,36,36,36,36,36,36,36,38,  38,38,38,38,38,38,38,38,38,39,
                         39,39,39,39,39,39,39,39,39,40 },
        /* CTn */   { 0 },
        /* CUn */   { 0 },
        /* CVn */   { 0 },
        /* ATn */   { 0 },
        /* AUn */   { 0 },
        /* AVn */   { 0 }
    },
    /* CTbN */
    {
        /* ³®« */   { 0 },
        /* În */   { 0 },
        /* Xn */   { 0 },
        /* ¾n */   { 0 },
        /* ånn */   { 0 },
        /* dn */   { 0 },
        /* @ */   { 0 },
        /* @ */   { 0 },
        /* ¤Ên */   { 99 },
        /*  n  */   { 0 },
        /*  n  */   { 0 },
        /*  n  */   { 0 },
        /*  Ún  */   { 0 },
        /* Ån */   { 0 },
        /* ­»n */   { 0 },
        /* Ï»n */   { 0 },
        /* úon */   { 0 },
        /* pn */   { 0 },
        /* pn */   { 0 },
        /* pn */   { 0 },
        /* ¨n */   { 0 },
        /* @n */   { 0 },
        /* ân */   { 0 },
        /* CTn */   { 99 },
        /* CUn */   { 99 },
        /* CVn */   { 99 },
        /* ATn */   { 0 },
        /* AUn */   { 0 },
        /* AVn */   { 0 }
    },
    /* AiCX */
    {
        /* ³®« */   { 0 },
        /* În */   { 0 },
        /* Xn */   { 0 },
        /* ¾n */   { 0 },
        /* ånn */   { 0 },
        /* dn */   { 0 },
        /* @ */   { 0 },
        /* @ */   { 0 },
        /* ¤Ên */   { 99 },
        /*  n  */   { 0 },
        /*  n  */   { 0 },
        /*  n  */   { 0 },
        /*  Ún  */   { 0 },
        /* Ån */   { 0 },
        /* ­»n */   { 0 },
        /* Ï»n */   { 0 },
        /* úon */   { 0 },
        /* pn */   { 0 },
        /* pn */   { 0 },
        /* pn */   { 0 },
        /* ¨n */   { 0 },
        /* @n */   { 0 },
        /* ân */   { 0 },
        /* CTn */   { 0 },
        /* CUn */   { 0 },
        /* CVn */   { 0 },
        /* ATn */   { 99 },
        /* AUn */   { 99 },
        /* AVn */   { 99 }
    }
    };
    
    /**
     * LN^¼ðæ¾
     * 
     * @see jp.ore.tool.stm.character.TWCharacter#getName()
     */
    public String getName() {
        return _name[charIndex];
    }

    /**
     * ^¼ðæ¾
     * 
     * @see jp.ore.tool.stm.character.TWCharacter#getStyleName()
     */
    public String getStyleName() {
        return _styleName[charIndex][_style[charIndex]];
    }

    /**
     * S^¼ðæ¾
     * 
     * @see jp.ore.tool.stm.character.TWCharacter#getStyleInfo()
     */
    public String[] getStyleInfo() {
        return _styleName[charIndex];
    }

    /**
     * IðÂ\SXienðæ¾
     * 
     * @return IðÂ\SXien
     */
    public String[] getXienInfo () {

        int[] maxXienPoints = getMaxXienPoints(Status.MAX_LEVEL);
        
        String[] tmpXienInfo = new String[maxXienPoints.length];
        int xienLength = 0;
        
        for(int i = 0; i < maxXienPoints.length; i++) {
            if(maxXienPoints[i] > 0) {
                tmpXienInfo[xienLength] = Status.XIEN_NAME[i];
                xienLength++;
            }
        }
        
        String[] xienInfo = new String[xienLength];
        for(int i = 0; i < xienLength; i++) {
            xienInfo[i] = tmpXienInfo[i];
        }
        
        return xienInfo;
    }

    /**
     * úXe[^Xðæ¾ 
     * 
     * @see jp.ore.tool.stm.character.TWCharacter#getDefaultStatus()
     */
    public int[] getDefaultStatus() {
        return _defaultStatus[charIndex][_style[charIndex]];
    }

    /**
     * úKv|Cgðæ¾
     * 
     * @see jp.ore.tool.stm.character.TWCharacter#getDefaultNeedPoints()
     */
    public int[] getDefaultNeedPoints() {
        return _defaultNeedPoints[charIndex][_style[charIndex]];
    }

    /**
     * úXienðæ¾
     * 
     * @see jp.ore.tool.stm.character.TWCharacter#getDefaultXien()
     */
    public int[] getDefaultXien() {
        return _defaultXien[charIndex][_style[charIndex]];
    }

    /**
     * úXienðæ¾
     * 
     * @see jp.ore.tool.stm.character.TWCharacter#getDefaultXienIndex()
     */
    public int getDefaultXienIndex(int styleIndex) {

    	int xienIndex = 0;
    	for (int i = 0; i < _defaultXien[charIndex][styleIndex].length; i ++ ) {
    		if(_defaultXien[charIndex][styleIndex][xienIndex] <= _defaultXien[charIndex][styleIndex][i]) {
    			xienIndex = i;
    		}
    	}
        return xienIndex;
    }

    /**
     * ^Ýè
     * 
     * @see jp.ore.tool.stm.character.TWCharacter#setStyleIndex(int)
     */
    public void setStyleIndex(int style) {
        _style[charIndex] = style;
    }

    /**
     * ^æ¾
     * 
     * @see jp.ore.tool.stm.character.TWCharacter#getStyleIndex()
     */
    public int getStyleIndex() {
        return _style[charIndex];
    }

    /**
     * ÅåzªÂ\Xienðæ¾
     * 
     * @see jp.ore.tool.stm.character.TWCharacter#getMaxXienPoints(int)
     */
    public int[] getMaxXienPoints(int level) {
        
        
        int[] tmpLevel = {
                level, level, level, level, level,
                level, level, level, level, level,
                level, level, level, level, level, level, level, level, level, level,
                level, level, level,
                level, level, level,
                level, level, level
                };
        
        for (int i = 0; i < tmpLevel.length; i++) {
            if ( _maxXien[charIndex][i].length < tmpLevel[i]) {
                tmpLevel[i] = _maxXien[charIndex][i].length;
            }
        }
        
        int[] xien = {
                _maxXien[charIndex][0][tmpLevel[0] - 1],
                _maxXien[charIndex][1][tmpLevel[1] - 1],
                _maxXien[charIndex][2][tmpLevel[2] - 1],
                _maxXien[charIndex][3][tmpLevel[3] - 1],
                _maxXien[charIndex][4][tmpLevel[4] - 1],
                _maxXien[charIndex][5][tmpLevel[5] - 1],
                _maxXien[charIndex][6][tmpLevel[6] - 1],
                _maxXien[charIndex][7][tmpLevel[7] - 1],
                _maxXien[charIndex][8][tmpLevel[8] - 1],
                _maxXien[charIndex][9][tmpLevel[9] - 1],
                _maxXien[charIndex][10][tmpLevel[10] - 1],
                _maxXien[charIndex][11][tmpLevel[11] - 1],
                _maxXien[charIndex][12][tmpLevel[12] - 1],
                _maxXien[charIndex][13][tmpLevel[13] - 1],
                _maxXien[charIndex][14][tmpLevel[14] - 1],
                _maxXien[charIndex][15][tmpLevel[15] - 1],
                _maxXien[charIndex][16][tmpLevel[16] - 1],
                _maxXien[charIndex][17][tmpLevel[17] - 1],
                _maxXien[charIndex][18][tmpLevel[18] - 1],
                _maxXien[charIndex][19][tmpLevel[19] - 1],
                _maxXien[charIndex][20][tmpLevel[20] - 1],
                _maxXien[charIndex][21][tmpLevel[21] - 1],
                _maxXien[charIndex][22][tmpLevel[22] - 1],
                _maxXien[charIndex][23][tmpLevel[23] - 1],
                _maxXien[charIndex][24][tmpLevel[24] - 1],
                _maxXien[charIndex][25][tmpLevel[25] - 1],
                _maxXien[charIndex][26][tmpLevel[26] - 1],
                _maxXien[charIndex][27][tmpLevel[27] - 1],
                _maxXien[charIndex][28][tmpLevel[28] - 1]
        };
        
        return xien;
    }

    /**
     * ú»
     */
    public void init() {
       _style[charIndex] = 0;
    }

}
