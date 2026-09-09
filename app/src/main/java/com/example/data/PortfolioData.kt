package com.example.data

enum class SkillCategory(val label: String) {
  ALL("All"),
  PEOPLE("People"),
  PROFESSIONAL("Professional"),
  INTERESTS("Interests")
}

data class SkillItem(
  val name: String,
  val category: SkillCategory,
  val summary: String,
  val details: String
)

data class ExperienceItem(
  val role: String,
  val duration: String,
  val company: String,
  val categoryTag: String,
  val description: String,
  val tags: List<String>
)

data class LeadershipMetric(
  val value: String,
  val label: String
)

data class LeadershipCard(
  val organization: String,
  val role: String,
  val badge: String,
  val subBadge: String,
  val description: String,
  val metrics: List<LeadershipMetric> = emptyList(),
  val tags: List<String> = emptyList()
)

data class FoundationalLeadership(
  val category: String,
  val title: String,
  val organization: String,
  val description: String
)

data class LearningItem(
  val title: String,
  val subtitle: String,
  val category: String,
  val iconName: String,
  val description: String,
  val outcome: String
)

data class AthleticCredential(
  val level: String,
  val title: String,
  val context: String,
  val description: String,
  val icon: String
)

data class SynergyNode(
  val title: String,
  val subtitle: String,
  val description: String,
  val angleDegrees: Float
)

object PortfolioRepository {
  val profileName = "Manthan Pruthy"
  val headline = "Artificial Intelligence & Data Science · Technology × Business × People"
  val quote = "“Curious about how technology, data, business and people come together.”"
  val university = "REVA University, Bengaluru"
  val cohort = "Class of 2026"
  val email = "pruthym@gmail.com"
  val phone = "+91 7676806233"
  val phoneRaw = "+917676806233"
  val linkedinUrl = "https://www.linkedin.com"
  val githubUrl = "https://github.com"

  val specialtyPills = listOf(
    "AI & Systems",
    "Data Science",
    "Business Strategy",
    "Leadership",
    "Product Thinking",
    "Executive PR"
  )

  val synergyNodes = listOf(
    SynergyNode(
      title = "Technology",
      subtitle = "Infrastructure & Systems",
      description = "Applied ML, AI Infrastructure, Cloud Frameworks & Systems Integration.",
      angleDegrees = 270f // Top
    ),
    SynergyNode(
      title = "Data",
      subtitle = "Analytics & Modeling",
      description = "Quantitative Models, Exploratory Analysis, Structured Pipelines & ETL.",
      angleDegrees = 0f // Right
    ),
    SynergyNode(
      title = "Business",
      subtitle = "Economics & Strategy",
      description = "Financial Processes, Commercial Margins, Unit Economics & Market Scaling.",
      angleDegrees = 90f // Bottom
    ),
    SynergyNode(
      title = "People",
      subtitle = "Leadership & PR",
      description = "Public Relations, High-Trust Teams, Community Stewardship & Stakeholder Alignment.",
      angleDegrees = 180f // Left
    )
  )

  val experiences = listOf(
    ExperienceItem(
      role = "PR Intern",
      duration = "3 Months",
      company = "Paytm",
      categoryTag = "Fintech Scale",
      description = "Professional exposure to public relations, communication, coordination and working within a large-scale, fast-moving financial technology ecosystem.",
      tags = listOf("Communication", "Professional Collaboration", "PR Exposure", "Workplace Adaptability")
    ),
    ExperienceItem(
      role = "Finance Intern",
      duration = "2 Months",
      company = "GIVA",
      categoryTag = "D2C Commerce",
      description = "Exposure to the finance function within a rapid-growth enterprise. Developed sharp insights into how commercial supply-chains, margins, and business operations connect with financial processes.",
      tags = listOf("Business Exposure", "Financial Understanding", "Attention to Detail", "Professional Work Experience")
    )
  )

  val mainLeadership = listOf(
    LeadershipCard(
      organization = "Indian Data Club",
      role = "Managing Director · 2nd Year",
      badge = "Current Mandate",
      subBadge = "REVA Chapter",
      description = "Contributing to the student community around data, technology and learning while developing deep, hands-on experience in leadership, communication, event execution and cross-team coordination.",
      metrics = listOf(
        LeadershipMetric("500+", "Community Engaged"),
        LeadershipMetric("12+", "Workshops & Sessions"),
        LeadershipMetric("100%", "Student Driven")
      )
    ),
    LeadershipCard(
      organization = "OSCODE",
      role = "Event Management Team",
      badge = "Technical Alliance",
      subBadge = "2025–26",
      description = "Driving hackathons, dev workshops, and collaborative coding marathons. Managing on-ground operations, developer relations, and stakeholder alignment.",
      tags = listOf("Dev Sprints", "Student Hackathons", "Technical Roundtables")
    )
  )

  val foundationalLeadership = listOf(
    FoundationalLeadership(
      category = "Leadership",
      title = "House Vice Captain",
      organization = "Baldwin Boys' High School",
      description = "Orchestrated inter-house athletic and cultural contingents, developing core team governance and discipline."
    ),
    FoundationalLeadership(
      category = "Academic Forum",
      title = "Executive Member",
      organization = "Science Forum · Christ Junior College",
      description = "Coordinated scientific colloquiums, guest seminars, and student research presentations."
    ),
    FoundationalLeadership(
      category = "Executive",
      title = "Core Committee",
      organization = "Eudaimonia",
      description = "Facilitated institutional flagship events, cross-department logistics, and visiting delegate reception."
    )
  )

  val skills = listOf(
    // People
    SkillItem(
      name = "Communication",
      category = SkillCategory.PEOPLE,
      summary = "Public briefings, executive reports & media relations.",
      details = "Refined verbal clarity, stakeholder briefings, written reporting and inter-team communications in both startup and corporate environments."
    ),
    SkillItem(
      name = "Leadership",
      category = SkillCategory.PEOPLE,
      summary = "Managing Director at Indian Data Club & campus initiatives.",
      details = "Guiding student cohorts, orchestrating team milestones with accountability, delegating responsibilities, and fostering community initiatives."
    ),
    SkillItem(
      name = "Teamwork",
      category = SkillCategory.PEOPLE,
      summary = "Collaborative execution with designers, coders & leads.",
      details = "Operating fluidly in multidisciplinary student and enterprise environments to achieve aligned objectives under tight timelines."
    ),
    SkillItem(
      name = "Collaboration",
      category = SkillCategory.PEOPLE,
      summary = "High-trust partnership building and shared ownership.",
      details = "Bridging consensus across diverse skillsets and executive priorities to create durable collaborative outcomes."
    ),
    SkillItem(
      name = "Event Management",
      category = SkillCategory.PEOPLE,
      summary = "End-to-end technical workshop and summit logistics.",
      details = "Large scale campus summits, scheduling, speaker management, venue setup, and seamless attendee registration workflows."
    ),

    // Professional
    SkillItem(
      name = "Project Management",
      category = SkillCategory.PROFESSIONAL,
      summary = "Structure, agile iteration, and milestone delivery.",
      details = "Scoping workstreams, tracking milestones, managing blockers, and delivering against deadlines in sprint cycles."
    ),
    SkillItem(
      name = "Time Management",
      category = SkillCategory.PROFESSIONAL,
      summary = "Disciplined scheduling across university & work.",
      details = "Balancing rigorous engineering academics with corporate internships, leadership roles, and athletic commitments."
    ),
    SkillItem(
      name = "Adaptability",
      category = SkillCategory.PROFESSIONAL,
      summary = "Fast acclimation to unfamiliar stacks and org cultures.",
      details = "Quickly integrating into diverse organizational structures from Paytm fintech ecosystem to GIVA retail operations."
    ),
    SkillItem(
      name = "Critical Thinking",
      category = SkillCategory.PROFESSIONAL,
      summary = "Data-backed decision making under ambiguity.",
      details = "Dissecting complex ambiguous problems using quantitative logic, root-cause diagnostics, and systematic breakdown."
    ),

    // Interests
    SkillItem(
      name = "Artificial Intelligence",
      category = SkillCategory.INTERESTS,
      summary = "Neural architectures & generative AI workflows.",
      details = "Neural network architectures, applied foundation models, embeddings, and intelligent agentic workflow integrations."
    ),
    SkillItem(
      name = "Data Science",
      category = SkillCategory.INTERESTS,
      summary = "Exploratory analytics, statistical pipelines & ETL.",
      details = "Statistical modeling, exploratory data analysis (EDA), data cleaning, pattern detection, and predictive workflows."
    ),
    SkillItem(
      name = "AI Tools",
      category = SkillCategory.INTERESTS,
      summary = "Prompt orchestration, agentic setups & tooling.",
      details = "Leveraging modern AI developer tooling, prompt engineering, and framework APIs for accelerated prototyping."
    ),
    SkillItem(
      name = "Business",
      category = SkillCategory.INTERESTS,
      summary = "Unit economics, business models & scale strategy.",
      details = "Market strategy, product positioning, monetization dynamics, cost structures, and financial process optimization."
    ),
    SkillItem(
      name = "Technology",
      category = SkillCategory.INTERESTS,
      summary = "Emerging systems, computational foundations.",
      details = "System design, cloud frameworks, software architectures, developer tooling, and modern computational infrastructure."
    ),
    SkillItem(
      name = "Learning New Domains",
      category = SkillCategory.INTERESTS,
      summary = "Rapid knowledge acquisition across verticals.",
      details = "Relentless curiosity to unpack emerging fields from aerospace telemetry and sensor circuits to quantitative analytics."
    )
  )

  val learningItems = listOf(
    LearningItem(
      title = "AI Tools Workshop",
      subtitle = "Applied Intelligence",
      category = "Technical Workshop",
      iconName = "terminal",
      description = "Hands-on generative workflows, prompt architecture & applied model orchestration. Gained practical experience integrating cutting-edge tools for development and research.",
      outcome = "Applied Intelligence"
    ),
    LearningItem(
      title = "CANsat Workshop",
      subtitle = "Sensor Systems",
      category = "Aerospace & Telemetry",
      iconName = "satellite_alt",
      description = "Satellite subsystems, telemetry sensor integration & collaborative telemetry data analysis under simulated launch environment constraints.",
      outcome = "Sensor Systems"
    ),
    LearningItem(
      title = "Magnachrista Volunteer",
      subtitle = "Social Impact",
      category = "Community Engagement",
      iconName = "volunteer_activism",
      description = "High-impact community engagement, operational logistics & event coordination facilitating university-level civic drives and social responsibility projects.",
      outcome = "Social Impact"
    )
  )

  val athleticCredentials = listOf(
    AthleticCredential(
      level = "State-Level Apex",
      title = "ICSE Swimming Meet",
      context = "2022–23 Season",
      description = "Competitive endurance, split-second discipline, stroke efficiency, and high-pressure performance execution.",
      icon = "pool"
    ),
    AthleticCredential(
      level = "District Aquatics",
      title = "District Swimming Competitions",
      context = "Christ Junior College",
      description = "Podium track, stroke mechanics optimization, and rigorous early-morning training cycles.",
      icon = "waves"
    ),
    AthleticCredential(
      level = "Team Athletics",
      title = "District Football Tournament",
      context = "Christ Junior College",
      description = "Tactical spatial awareness, mid-game communication, tactical positioning, and high-intensity on-pitch collaboration.",
      icon = "sports_soccer"
    )
  )
}
